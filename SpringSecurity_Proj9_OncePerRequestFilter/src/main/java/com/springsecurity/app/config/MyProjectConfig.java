package com.springsecurity.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.springsecurity.app.filter.AuthenticationLoggingFilter;

@Configuration
public class MyProjectConfig {
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.httpBasic(Customizer.withDefaults())
		            .addFilterAfter(new AuthenticationLoggingFilter(), BasicAuthenticationFilter.class)
		             .authorizeHttpRequests(c-> c.anyRequest().authenticated());
	                
		
		return  httpSecurity.build();
		             
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		//create users
				UserDetails u1 = User.withUsername("aman")
				     .password("aman123")
				     .authorities("write")
				     .build();
				
				//create users
						UserDetails u2 = User.withUsername("priya")
						     .password("priya123")
						     .authorities("write")
						     .build();
			return new InMemoryUserDetailsManager(u1, u2);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return NoOpPasswordEncoder.getInstance();
		
	}

}
