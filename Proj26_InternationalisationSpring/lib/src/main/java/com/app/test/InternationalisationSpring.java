package com.app.test;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InternationalisationSpring {
	
    public static void main(String[] args) {
		ApplicationContext context  = null;
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
	    Locale locale = new Locale("hi", "IN");
	    
	    String msg = context.getMessage("loginBtn2", new String[] {"action"}, "login ka button", locale);
	    String msg2 = context.getMessage("regBtn", null, locale);
	    String msg3 = context.getMessage("buyBtn", null, locale);
	    System.out.println(msg);
	    System.out.println(msg2);
	    System.out.println(msg3);
	    
	}
}
