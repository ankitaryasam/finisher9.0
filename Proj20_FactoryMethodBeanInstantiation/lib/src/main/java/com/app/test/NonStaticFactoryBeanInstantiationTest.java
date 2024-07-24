package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NonStaticFactoryBeanInstantiationTest {
	
	
	public static void main(String[] args) {
		ApplicationContext context = null;
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		String s2 = context.getBean("s2", String.class);
		System.out.println(s2);
		System.out.println("-------------------------------");
		
		
		String s4 = context.getBean("s4", String.class);
		System.out.println(s4);
	}

}
