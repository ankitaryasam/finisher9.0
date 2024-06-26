package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.beans.User;

public class IOC_Container_Test {
	
    public static void main(String[] args) {
    	
    	//ioc container - ApplicationContext
    	ApplicationContext context = null;
    	context = new ClassPathXmlApplicationContext("com/app/config/beanConfig.xml");
    	
        User user = (User)context.getBean("user");
        System.out.println(user.hashCode());
        user.showUser();
	}
}


