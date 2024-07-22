package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.beans.Student;

public class DependencyLookupTest {
	
	public static void main(String[] args) {
		ApplicationContext context = null;
		
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student student = context.getBean("student", Student.class);
		
		student.markAttendance();
		student.giveTest();
		student.startOnlineLiveClass();
		System.out.println(student);
	}

}
