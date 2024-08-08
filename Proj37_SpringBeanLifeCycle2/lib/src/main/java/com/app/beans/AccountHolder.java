package com.app.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class AccountHolder implements InitializingBean, DisposableBean {
	
	private String acHolderName;

	public void setAcHolderName(String acHolderName) {
		this.acHolderName = acHolderName;
	}

	@Override
	public String toString() {
		return "AccountHolder [acHolderName=" + acHolderName + "]";
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy method invoked----account holder");
		acHolderName=null;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("init method invoked----AccountHolder");
		if(acHolderName==null) {
			throw new IllegalArgumentException("account holder name cannot be null");
		}
		
	}
	
	

}
