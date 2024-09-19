package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.service.BankService;

public class AspectjAop_Annotation_Test {
	
	public static void main(String[] args) {
		ApplicationContext context  = null;
		
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		BankService bs = context.getBean("bankService", BankService.class);
		System.out.println("proxy class object class name : "+ bs.getClass().getName());
		
		
		
		System.out.println(bs.calSi(1000, 10, 11));
		System.out.println(bs.calCi(1000, 10, 12));
		
		((AbstractApplicationContext)context).close();
		
	}

}
