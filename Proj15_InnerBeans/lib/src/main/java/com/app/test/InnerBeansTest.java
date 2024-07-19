package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.beans.User;

public class InnerBeansTest {
     public static void main(String[] args) {
		ApplicationContext context = null;
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		 User u = context.getBean("u1", User.class);
		 
		
		 
		 System.out.println(u);
	
	}
}
