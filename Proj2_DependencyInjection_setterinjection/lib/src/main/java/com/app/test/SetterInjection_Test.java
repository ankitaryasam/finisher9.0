package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.beans.User;

public class SetterInjection_Test {
	
	public static void main(String[] args) {
      
		//ioc container
		ApplicationContext context = null;
		context = new ClassPathXmlApplicationContext("com/app/config/applicationContext.xml");
		
		User user = (User)context.getBean("user");
		user.showUserInfo()	;
		
		
		
	}

}
