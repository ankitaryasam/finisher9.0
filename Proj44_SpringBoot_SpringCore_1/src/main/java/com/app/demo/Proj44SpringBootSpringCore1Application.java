package com.app.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.app.demo.beans.Student;

@SpringBootApplication
public class Proj44SpringBootSpringCore1Application {

	public static void main(String[] args) {
		ApplicationContext context = null;
		
		context = SpringApplication.run(Proj44SpringBootSpringCore1Application.class, args);
	    System.out.println("hello welcome to the spring boot first project");
	   
	    System.out.println(context.getClass().getName());
	    
	   Student s = context.getBean("student", Student.class);
	   System.out.println(s);
	
	}

}
