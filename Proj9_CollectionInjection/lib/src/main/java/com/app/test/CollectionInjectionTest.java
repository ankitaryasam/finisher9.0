package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.beans.CollegeInfo;
import com.app.beans.Employee;
import com.app.beans.Faculty;
import com.app.beans.Student;
import com.app.beans.User;

public class CollectionInjectionTest {
	
	public static void main(String[] args) {
		ApplicationContext context = null;
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Student student = context.getBean("student", Student.class);
	     System.out.println(student);
	     
	     System.out.println("---------------------------");
	     
	     
	     Faculty fac = context.getBean("faculty", Faculty.class);
	     System.out.println(fac);
	     System.out.println("---------------------------");
	     
	     Employee emp = context.getBean("emp", Employee.class);
	     System.out.println(emp);
	     
	     
	     System.out.println("---------------------------");
	     User user = context.getBean("user", User.class);
	     System.out.println(user);
	     
	     
	     
	     
	     System.out.println("---------------------------");
	     CollegeInfo clg = context.getBean("clg", CollegeInfo.class);
	     System.out.println(clg);
	     
	     
	     
	     
	     
	     
	     
	
	}

}
