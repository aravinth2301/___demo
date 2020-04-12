package au.company.product.admin.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import au.company.product.admin.service.AppUserService;
import au.company.product.lib.common.domain.admin.AppUser;
import au.company.product.lib.common.domain.admin.Function;
import au.company.product.lib.common.domain.admin.Role;
import au.company.product.lib.common.util.ServiceURL;
import au.company.product.lib.common.util._Controller;

@RestController
@RequestMapping("/v1")
public class UserControllerV1 implements _Controller {

	private static final Logger log = LogManager.getLogger(UserControllerV1.class);

	@Autowired
	private AppUserService appUserService;

	@PostMapping(value = ServiceURL.ROLE_ADD)
	public @ResponseBody ResponseEntity<Role> saveRole(@RequestBody Role role) {
		return success(appUserService.saveRole(role));
	}

	@GetMapping(value = ServiceURL.ROLE_FETCH_BY_NAME)
	public ResponseEntity<Role> fetchRole(@PathVariable("name") String name) {
		 return success(appUserService.fetchRole(name));
	}

	@GetMapping(value = ServiceURL.USER_FETCH_BY_NAME)
	public ResponseEntity<AppUser> fetchUser(@PathVariable("name") String name) {
		return success(appUserService.fetchAppUser(name));
	}

	@GetMapping(value = ServiceURL.USER_FETCH_BY_ID)
	public ResponseEntity<AppUser> fetchUser(@PathVariable("userId") Long userId) {
		return success(appUserService.fetchAppUsers(userId));
	}

	@PostMapping(value = ServiceURL.USER_ADD)
	public @ResponseBody ResponseEntity<AppUser> saveUser(@RequestBody AppUser user) {
		return success(appUserService.saveUser(user));
	}

	@PostMapping(value = ServiceURL.USER_FETCH)
	public @ResponseBody ResponseEntity<List<AppUser>> users(@RequestBody AppUser appUser) {
		return success(appUserService.fetchAppUsers(appUser));
	}

	@PostMapping(value = ServiceURL.FUNCTION_FETCH)
	public @ResponseBody ResponseEntity<List<Function>> fetchFunction() {
		return success(appUserService.fetchFunctions());
	}

	@PostMapping(value = ServiceURL.CHANGE_PSW)
	public @ResponseBody ResponseEntity<AppUser> changePassword(@RequestBody AppUser appUser) {
		if (log.isDebugEnabled()) {
			log.debug(appUser);
		}
		return success(appUserService.updateLastLogin(appUser));
	}
}
