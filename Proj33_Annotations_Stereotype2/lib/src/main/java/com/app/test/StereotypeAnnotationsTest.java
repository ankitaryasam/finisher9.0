package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.beans.Employee;

public class StereotypeAnnotationsTest {
	
	public static void main(String[] args) {
		ApplicationContext context =null;
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	    
		Employee emp1 = context.getBean(Employee.class);
		Employee emp2 = context.getBean(Employee.class);
	
	}

}
