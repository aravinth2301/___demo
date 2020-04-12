package au.company.product.admin.service;

import java.util.List;

import au.company.product.lib.common.domain.admin.AppUser;
import au.company.product.lib.common.domain.admin.Function;
import au.company.product.lib.common.domain.admin.Role;

public interface AppUserService {

    List<AppUser> fetchAppUsers(AppUser appUser);

    AppUser fetchAppUser(String appUser);

    AppUser fetchAppUsers(Long userId);

    List<Function> fetchFunctions();

    Role fetchRole(String name);

    AppUser saveUser(AppUser appUser);

    AppUser updateLastLogin(AppUser appUser);

    Role saveRole(Role role);
}
