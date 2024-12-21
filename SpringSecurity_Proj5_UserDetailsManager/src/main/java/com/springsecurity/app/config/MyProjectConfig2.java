package com.springsecurity.app.config;

import javax.sql.DataSource;

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
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MyProjectConfig2 {
	
	@Bean
	public JdbcUserDetailsManager userDetailsManager(DataSource dataSource) {
		JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
		
		//custom query to get a user
		userDetailsManager.setUsersByUsernameQuery("SELECT uname, pass, enabled FROM myuser WHERE uname=?");
		
		//get the user authorities
		userDetailsManager.setAuthoritiesByUsernameQuery("SELECT uname, authority FROM myuser_authorities WHERE uname=?");
		
		
		//custom query to create a user
		userDetailsManager.setCreateUserSql("INSERT into myuser(uname, pass, enabled) values(?,?,?)");
		
		
		//custom query to create the user authority
		userDetailsManager.setGroupAuthoritiesSql("INSERT into myuser_authorities (uname, authority) values (?,?)");
		
		
		
		return userDetailsManager;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
}
