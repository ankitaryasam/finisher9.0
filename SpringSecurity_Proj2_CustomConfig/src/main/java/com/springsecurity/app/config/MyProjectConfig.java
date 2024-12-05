package com.springsecurity.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class MyProjectConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		
		UserDetails userDetails = User.withUsername("amitpal")
									  .password("pass123")
									  .authorities("read")
									  .build();
		

		UserDetails userDetails2 = User.withUsername("manish")
									  .password("mn123")
									  .authorities("read")
									  .build();
		
		UserDetails userDetails3 = User.withUsername("ayaz")
				  .password("ayaz123")
				  .authorities("read")
				  .build();
		
		UserDetailsService userDetailsService = new InMemoryUserDetailsManager(userDetails, userDetails2, userDetails3);
		return userDetailsService;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
}
