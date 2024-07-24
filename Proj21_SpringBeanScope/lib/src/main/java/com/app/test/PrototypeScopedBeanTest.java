package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.beans.Faculty;


public class PrototypeScopedBeanTest {
	
	public static void main(String[] args) {
		ApplicationContext context = null;
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Faculty f1 = context.getBean("faculty", Faculty.class);
		System.out.println(f1.hashCode());
		
		Faculty f2 = context.getBean("faculty", Faculty.class);
		System.out.println(f2.hashCode());
		
		Faculty f3 = context.getBean("faculty", Faculty.class);
		System.out.println(f3.hashCode());
	}

}
