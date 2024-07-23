package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StaticFactoryBeanInstantiationTest {
	
	public static void main(String[] args) {
		ApplicationContext context = null;
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Class c1 = context.getBean("c1", Class.class);
		System.out.println(c1);
	}

}
