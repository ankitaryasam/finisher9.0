package com.springsecurity.app.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.springsecurity.app.entity.UserEntity;

public class UserEntityDetails implements UserDetails {
	
	private String email; // consider email here
	private String password;
	private List<GrantedAuthority> authorities;
	
	public UserEntityDetails(UserEntity userEntity) {
		this.email=userEntity.getEmail();
		this.password=userEntity.getPassword();
		this.authorities = List.of(userEntity.getRole().split(",")).stream()
							.map(role -> new SimpleGrantedAuthority(role.trim()))
							.collect(Collectors.toList());
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
	   return email;
	}

}
