package com.springsecurity.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MyProjectConfig {
	
	@Autowired
	private OtpAuthenticationProvider authProvider;
	
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		 return http.getSharedObject(AuthenticationManagerBuilder.class)
	                .authenticationProvider(authProvider)
	                .build();
	}
	
	
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authenticationManager(authenticationManager(http))
			.authorizeHttpRequests(c-> 
				c.requestMatchers("/auth/generate-otp", "/auth/login").permitAll()
				.anyRequest().authenticated());
		return http.build();
		
	}
	
}
