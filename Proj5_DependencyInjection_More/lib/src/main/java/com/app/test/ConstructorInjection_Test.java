package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.beans.Student;

public class ConstructorInjection_Test {
	
	public static void main(String[] args) {
		ApplicationContext context = null;
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	    // get the bean
		Student student = (Student)context.getBean("student");
		student.startMyCourse();
		System.out.println(student);
	
	}

}
