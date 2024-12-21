package com.springsecurity.app.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUser implements UserDetails {
	
	private final String username;
	private final String password;
	private final String authority;
	
	public MyUser(String username, String password, String authority) {
		this.username=username;
		this.password=password;
		this.authority=authority;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return List.of(()-> authority);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

}
