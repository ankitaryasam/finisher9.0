package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.beans.Student;

public class CollectionMergingTest {
	
	public static void main(String[] args) {
		ApplicationContext context = null;
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Student s1 = context.getBean("s1", Student.class);
		Student s2 = context.getBean("com.app.beans.Student", Student.class);
		Student s3 = context.getBean("com.app.beans.Student", Student.class);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}

}
