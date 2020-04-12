package au.company.product.admin.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import au.company.product.admin.dao.AppUserRoleCRUD;
import au.company.product.admin.dao.FunctionCRUD;
import au.company.product.admin.dao.RoleCRUD;
import au.company.product.admin.dao.RoleFunctionCRUD;
import au.company.product.admin.domain.AppUserRole;
import au.company.product.admin.domain.RoleFunction;
import au.company.product.admin.service.AppUserService;
import au.company.product.lib.common.domain.admin.AppUser;
import au.company.product.lib.common.domain.admin.Function;
import au.company.product.lib.common.domain.admin.Role;
import au.company.product.lib.common.util.BadRequestException;
import au.company.product.lib.common.util.Error;
import au.company.product.lib.common.util.ServiceURL;
import au.company.product.lib.dao.AppUserCRUD;

@Service
public class AppUserServiceImpl implements AppUserService {

    private static final Logger LOG = LogManager.getLogger(AppUserServiceImpl.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AppUserCRUD crudAppUserDao;

    @Autowired
    private RoleCRUD crudRoleDao;

    @Autowired
    private AppUserRoleCRUD crudAppUserRoleDao;

    @Autowired
    private FunctionCRUD crudFunctionDao;

    @Autowired
    private RoleFunctionCRUD crudRoleFunctionDao;


    @PostConstruct
    private void init(){
        addMetaFunctions();
        addMetaUser();

    }

    @Override
    public List<AppUser> fetchAppUsers(AppUser appUser) {
        List<AppUser> appUsers = null;
        if(appUser==null || appUser.getUsername()==null)
            appUsers =  crudAppUserDao.findAllUsers();
        else
            appUsers  = new ArrayList<>();
        return appUsers;
    }

    @Override
    public AppUser fetchAppUser(String appUser) {
        return crudAppUserDao.findAppUser(appUser);
    }

	@Override
	public AppUser fetchAppUsers(Long userId) {
		Optional<AppUser> optUser = crudAppUserDao.findById(userId);
		return optUser.orElseThrow(
				() -> new BadRequestException(Error.USER_NOT_FOUND.getCode(), Error.USER_NOT_FOUND.getDescription()));
	}

    @Override
    public List<Function> fetchFunctions(){
        return crudFunctionDao.fetchAll();
    }

    @Override
    public Role fetchRole(String name){
    	Role role = crudRoleDao.findRole(name);
    	List<Function> functions = crudRoleFunctionDao.fetchByRoleId(role.getId());
    	role.setFunctions(functions);
        return role;
    }


    @Override
    @Transactional
    public AppUser saveUser(AppUser appUser){
        if(LOG.isDebugEnabled()){
            LOG.debug(appUser.toString());
        }
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        AppUser savedUser = crudAppUserDao.save(appUser);
        if(appUser.getAuthorities()!=null){
            appUser.getAuthorities().forEach(role->{
                if(role.getDelete()!=null && role.getDelete() ){
                    AppUserRole appUserRole = new AppUserRole(appUser,role);
                    crudAppUserRoleDao.delete(appUserRole);
                }else{
                    List<AppUserRole> userRoles = crudAppUserRoleDao.findUserRole(appUser.getId(), role.getId());
                    if(!(userRoles != null && !userRoles.isEmpty())){
                        AppUserRole appUserRole = new AppUserRole(appUser,role);
                        crudAppUserRoleDao.save(appUserRole);
                    }
                }

            });
        }else{
            throw new BadRequestException(Error.USER_AUTH_NOT_FOUND.getCode(),Error.USER_AUTH_NOT_FOUND.getDescription());
        }

        assignRole(savedUser, crudAppUserRoleDao.findAppUserRoleByUser(savedUser.getId()));

        if(LOG.isDebugEnabled()){
            LOG.debug(String.format("User saved successfully %s",savedUser.getUsername()));
        }
        return savedUser;
    }

    @Override
	public AppUser updateLastLogin(AppUser appUser) {
		Optional<AppUser> userOpt = crudAppUserDao.findById(appUser.getId());
		AppUser user = userOpt.orElseThrow(
				() -> new BadRequestException(Error.USER_NOT_FOUND.getCode(), Error.USER_NOT_FOUND.getDescription()));
		if (appUser.getNewPassword() != null)
			user.setPassword(passwordEncoder.encode(appUser.getNewPassword()));
		user.setLastLoginAt(new Date());
		return crudAppUserDao.save(user);
	}

    @Override
    @Transactional
    public Role saveRole(Role role){
        role=crudRoleDao.save(role);
        if(role.getFunctions()!=null){
            for (Function function : role.getFunctions()) {
                RoleFunction roleFunction = new RoleFunction(role,function);
                boolean isDeleted = function.getDelete();
                if(isDeleted){
                    crudRoleFunctionDao.delete(roleFunction);
                }else{
                    crudRoleFunctionDao.save(roleFunction);
                }
            }
        }
        return role;
    }

    private void addMetaUser(){
    	final String name = "admin";
        AppUser appUser = crudAppUserDao.findAppUser(name);
        Role role = crudRoleDao.findRole("R_ADMIN");
        if(role == null){
            role = new Role();
            role.setName("R_ADMIN");
            role = crudRoleDao.save(role);
        }

        if(appUser==null){
            appUser = new AppUser();
            appUser.setUsername("admin");
            appUser.setPassword(passwordEncoder.encode(name));
            appUser= crudAppUserDao.save(appUser);
            AppUserRole appUserRole = new AppUserRole(appUser,role);
            crudAppUserRoleDao.save(appUserRole);
        }
        addMetaRoleFunction(role);
        if(LOG.isDebugEnabled()){
            LOG.debug(String.format("User Id %s",appUser.getId()));
        }
    }

    
	private void addMetaRoleFunction(Role role) {
		List<Function> functions = crudFunctionDao.fetchAll();
		functions.forEach(function -> {
			RoleFunction roleFunction = new RoleFunction(role, function);
			crudRoleFunctionDao.save(roleFunction);
		});
	}

	private void addMetaFunctions() {
		List<Function> functions = crudFunctionDao.fetchAll();
		if (functions == null || functions.isEmpty())
			ServiceURL.getFunctions().forEach(function -> crudFunctionDao.save(function));
	}

	private void assignRole(AppUser user, List<AppUserRole> userRoles) {
		List<Role> roles = new ArrayList<>();
		if (userRoles != null && !userRoles.isEmpty()) {
			userRoles.forEach(userRole -> roles.add(userRole.getRole()));
		}
		user.setAuthorities(roles);
	}
}