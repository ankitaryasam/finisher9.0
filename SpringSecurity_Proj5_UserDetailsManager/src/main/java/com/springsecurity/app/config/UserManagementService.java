package com.springsecurity.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class UserManagementService {
	
	@Autowired
	private JdbcUserDetailsManager userDetailsManager;
	
	//creating the new user
	public void createUser(String username, String password, String... authority) {
		UserDetails u = User.withUsername(username)
		    .password(password)
		    .authorities(authority)
		    .build();
		
		userDetailsManager.createUser(u);
	}
	
	public void deleteUser(String username) {
		userDetailsManager.deleteUser(username);
	}
	
	public boolean doesUserExist(String username) {
		return userDetailsManager.userExists(username);
	}

}
