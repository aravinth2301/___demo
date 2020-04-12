package au.company.product.lib.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import au.company.product.lib.dao.AppUserCRUD;

@Service
public class UserServiceImpl implements UserDetailsService{

	@Autowired
	private AppUserCRUD appUserCRUD;
	
	@Override
	public UserDetails loadUserByUsername(String username){
		return appUserCRUD.findByUsername(username).orElseThrow(()->new UsernameNotFoundException(username));
	}

}
