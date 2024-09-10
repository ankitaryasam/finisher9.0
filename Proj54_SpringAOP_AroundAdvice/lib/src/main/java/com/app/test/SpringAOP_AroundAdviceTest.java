package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.service.BankService;

public class SpringAOP_AroundAdviceTest {
	
	public static void main(String[] args) {
		//ioc container
		
		ApplicationContext context = null;
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		BankService bs = context.getBean("pfb", BankService.class);
		
		float si = bs.calSi(1200, 12, 2);
		System.out.println("Interest amt : " + si);
		
		
		System.out.println(bs.getClass());
		((AbstractApplicationContext)context).close();
	}

}
