package com.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springboot.demo.beans.Student;
import com.springboot.demo.beans.User;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		
		ApplicationContext context = null;
		User user = null;
		Student student = null;
		
		context = SpringApplication.run(DemoApplication.class, args);
	    
		user = context.getBean("user", User.class);
		System.out.println(user.getName() + " " + user.getUserId() + " " + user.getEmail());
		
		
		System.out.println("----------------------");
		
		
		
		student = context.getBean("student", Student.class);
		System.out.println(student.getId() + " " + student.getMarks() + " " + student.getEmail());
		
		System.out.println("--------------");
		
		System.out.println(student.getSubjects());
		
		
		System.out.println("-----------------");
		System.out.println(student.getExtraActivities());
		
		System.out.println("-----------------");
		System.out.println(student.getContactNo());
		
		System.out.println("---------------");
		System.out.println(student.getPlacementChoice().getCompName() + " " + student.getPlacementChoice().getSalary());
		
		
		
		
	}

}
