package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.beans.AlarmNote;

public class FactoryBeanTest {
	
	public static void main(String[] args) {
		ApplicationContext context  = null;
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		AlarmNote alm = context.getBean("alarmNote", AlarmNote.class);
		
		alm.scheduler();
	}

}
