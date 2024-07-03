package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.beans.Amazon;

public class DependencyInjection_StrategyDp_Test {
	
	public static void main(String[] args) {
		//ioc container
		
		ApplicationContext context = null;
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Amazon amazon = (Amazon)context.getBean("amazon");
		String status = amazon.checkDeliveryStatus(90032);
		System.out.println(status);
		
		String returnStatus = amazon.returnOrder(90032);
		System.out.println(returnStatus);
	}

}
