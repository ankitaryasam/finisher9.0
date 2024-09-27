package com.app.bank.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.bank.service.BankService;

public class DistributedTxMgmtTest {

	
	public static void main(String[] args) {
		ApplicationContext context = null;
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		BankService bankService = context.getBean("bankService", BankService.class);
		try {
			bankService.transferMoney(9001, 10010, 9000.00f);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			((AbstractApplicationContext)context).close();
		}
	}
}
