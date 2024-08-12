package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.beans.BankLoanInteresetCalculator;

public class MethodReplacerTest {
	
	public static void main(String[] args) {
		
		ApplicationContext context = null;
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		BankLoanInteresetCalculator loanCal = context.getBean("loanCal", BankLoanInteresetCalculator.class);
	    float si = loanCal.calLoanInterest(1000, 12, 2);
	    System.out.println(si);
	}

}
