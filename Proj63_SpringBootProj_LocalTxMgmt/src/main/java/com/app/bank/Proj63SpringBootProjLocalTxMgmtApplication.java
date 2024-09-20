package com.app.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.app.bank.service.BankService;

@SpringBootApplication
public class Proj63SpringBootProjLocalTxMgmtApplication {

	public static void main(String[] args) {
		
		ApplicationContext context = null;
		
		context = SpringApplication.run(Proj63SpringBootProjLocalTxMgmtApplication.class, args);
	
	     
		BankService bs = context.getBean("bankService", BankService.class);
		
		
		try {
			boolean status = bs.transferMoney(123456785, 123456790, 8000.00f);
			System.out.println("Money transfer request successfull : " + status);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}
