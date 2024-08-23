package com.app.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.app.student.controller.StudentMainAppController;

//this is our runner class/main class
@SpringBootApplication
public class Proj46SpringBootSpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = null; 
	   context=SpringApplication.run(Proj46SpringBootSpringJdbcApplication.class, args);
	
	  
	   StudentMainAppController controller = context.getBean("controller", StudentMainAppController.class);
	   try {
		  System.out.println( controller.fetchAllStudentsByCourseName("java"));
		   
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   finally {
		   ((ConfigurableApplicationContext)context).close();
	   }
	}

}
