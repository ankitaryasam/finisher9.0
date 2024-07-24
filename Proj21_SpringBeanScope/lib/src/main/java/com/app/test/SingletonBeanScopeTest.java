package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.beans.Student;

public class SingletonBeanScopeTest {
	
	public static void main(String[] args) {
		ApplicationContext context = null;
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student s1 = context.getBean("student", Student.class);
		System.out.println(s1.hashCode());
		
		Student s2 = context.getBean("student", Student.class);
		System.out.println(s2.hashCode());
		

		Student s3 = context.getBean("student", Student.class);
		System.out.println(s3.hashCode());
	}

}
