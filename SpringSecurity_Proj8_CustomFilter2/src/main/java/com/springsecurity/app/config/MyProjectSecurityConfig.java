package com.springsecurity.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class MyProjectSecurityConfig {
	
	private final StaticKeyAuthenticationFilter filter;
	
	public MyProjectSecurityConfig(StaticKeyAuthenticationFilter filter) {
		this.filter=filter;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.addFilterAt(filter, BasicAuthenticationFilter.class)
		    .authorizeHttpRequests(c-> c.anyRequest().permitAll());
		
		return http.build();
		    

	}

}
