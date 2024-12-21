package com.springsecurity.app.config;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

	private List<UserDetails> users;
	
	public UserDetailsServiceImpl(List<UserDetails> users) {
		this.users=users;
		
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return users.stream()
		 		.filter(
		 			 u -> u.getUsername().equals(username)
		 			)
		 		.findFirst()
		 		.orElseThrow(()-> new UsernameNotFoundException("user not found"));
	}

}
