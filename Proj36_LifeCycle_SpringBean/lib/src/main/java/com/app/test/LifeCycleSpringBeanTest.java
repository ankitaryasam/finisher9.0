package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.beans.User;

public class LifeCycleSpringBeanTest {
	
	public static void main(String[] args) {
		ApplicationContext context = null;
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		User user = context.getBean("user", User.class);
		System.out.println(user);
		
		
		((AbstractApplicationContext)context).close();
		
		System.out.println(user);
		
	}

}
