package com.springsecurity.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.ldap.userdetails.LdapUserDetailsManager;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MyProjectConfig {
	
	@Bean
	public LdapContextSource ldapContextSource() {
		LdapContextSource contextSource = new LdapContextSource();
		contextSource.setBase("dc=example,dc=com");
		contextSource.setUrl("ldap://localhost:8389");
		contextSource.setBase("dc=example,dc=com");   // Base DN for LDAP queries
        contextSource.setUserDn("cn=admin,dc=example,dc=com"); // Admin user DN
        contextSource.setPassword("admin");            // Admin password
        contextSource.afterPropertiesSet();     
		return contextSource;
	}
	
	@Bean
	public LdapUserDetailsManager ldapUserDetailsManager(LdapContextSource ldapContextSource) {
		LdapUserDetailsManager ldapUserDetailsManager = new LdapUserDetailsManager(ldapContextSource);
	    ldapUserDetailsManager.setGroupSearchBase("ou=users");
		
		return ldapUserDetailsManager;
	}
	

	
	
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.httpBasic(Customizer.withDefaults())
					.authorizeHttpRequests(c -> c.anyRequest().authenticated());
		
		
		
		return httpSecurity.build();
					
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
}
