package com.springsecurity.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.app.dto.LoginRequestDto;
import com.springsecurity.app.entity.UserEntity;
import com.springsecurity.app.service.JwtService;
import com.springsecurity.app.service.UserDetailsServiceImpl;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private UserDetailsServiceImpl service;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JwtService jwtService;
	
	@PostMapping("/register-new-user")
	public String registerNewUser(@RequestBody UserEntity entity) {
		return service.createUser(entity);
	}
	
	@PostMapping("/login")
	public String authenticateAndGenerateToken(@RequestBody LoginRequestDto loginRequestDto) {
		Authentication authentication = authManager.
										authenticate(
										new UsernamePasswordAuthenticationToken(
												loginRequestDto.getEmail(), 
												loginRequestDto.getPassword()));
		
		if(authentication.isAuthenticated()) {
			return jwtService.generateToken(loginRequestDto.getEmail());
		}
		else {
			throw new UsernameNotFoundException("Invalid user credentials");
		}
				
				
	}

}
