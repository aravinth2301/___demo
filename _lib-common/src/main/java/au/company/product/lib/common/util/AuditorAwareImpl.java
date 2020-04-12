package au.company.product.lib.common.util;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import au.company.product.lib.common.domain.admin.AppUser;

public class AuditorAwareImpl implements AuditorAware<AppUser> {
    @Override
    public Optional<AppUser> getCurrentAuditor() {
    	AppUser appUser = null;
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth!=null) {
    		appUser = (AppUser) auth.getPrincipal();
    		  return Optional.of(appUser);
    	}
    	return Optional.empty();
    }

}