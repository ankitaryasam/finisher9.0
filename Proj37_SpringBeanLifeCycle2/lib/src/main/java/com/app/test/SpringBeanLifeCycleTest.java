package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.beans.AccountHolder;
import com.app.beans.CreditCard;
import com.app.beans.Employee;
import com.app.beans.Student;
import com.app.beans.User;

public class SpringBeanLifeCycleTest {
	
	public static void main(String[] args) {
		ApplicationContext context = null;
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
	 User u =	context.getBean("user", User.class);
	 Employee emp =	context.getBean("emp", Employee.class);
	 Student s = context.getBean("student", Student.class);
	 AccountHolder acHolder = context.getBean("acHolder", AccountHolder.class);
	 CreditCard card = context.getBean("cc", CreditCard.class);
	 System.out.println(u);
	 System.out.println(emp);
	 System.out.println(s);
	 System.out.println(acHolder);
	 System.out.println(card);
	 
	 ((AbstractApplicationContext)context).close();
	}

}
