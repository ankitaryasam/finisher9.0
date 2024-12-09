package com.springsecurity.app.config;

import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		//write the custom auth logic here
		
		//collect the username and password first
		
		String username = authentication.getName();
		String password = String.valueOf(authentication.getCredentials());
		
		if("amit".equals(username) && "john123".equals(password)) {
			return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList());
		}
		else {
			throw new AuthenticationCredentialsNotFoundException("given user credentials not found");
			
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

	
	
}
