package com.springsecurity.app;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springsecurity.app.config.UserManagementService;

@SpringBootApplication
public class SpringSecurityProj1BasicsApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = null;
		context = SpringApplication.run(SpringSecurityProj1BasicsApplication.class, args);
	
		
		UserManagementService service = context.getBean(UserManagementService.class);
		service.createUser("ranjit", "ranjit12", "read", "write");
	}

}
