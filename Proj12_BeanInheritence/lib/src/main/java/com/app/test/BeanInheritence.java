package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.beans.Car;

public class BeanInheritence {
	
	
	public static void main(String[] args) {
		ApplicationContext context = null;
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Car car1 = context.getBean("car1", Car.class);
		System.out.println(car1);
		
		Car car2 = context.getBean("car2", Car.class);
		System.out.println(car2);
		
		
		
		
		
	}

}
