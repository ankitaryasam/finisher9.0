package com.app.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class CreditCard  implements InitializingBean, DisposableBean{
	
	private String cardNo;

	
	
	
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
	public void init() {
		System.out.println("init() method----cc");
	}
	
	public void mydestroy() {
		System.out.println("destroy() method----cc");
	}
	


	@PostConstruct
	public void initialize() {
		System.out.println("init life cycle method---CreditCard");
		if(cardNo == null) {
			throw new IllegalArgumentException("card no. is required");
		}
	}
	
	@PreDestroy
	public void destroyBean() {
		System.out.println("destroy method invoked----CreditCard");
		cardNo = null;
	}


	@Override
	public String toString() {
		return "CreditCard [cardNo=" + cardNo + "]";
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("CreditCard.afterPropertiesSet()");
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("CreditCard.destroy()");
		
	}
	
	

}
