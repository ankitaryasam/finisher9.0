package com.app.beans;

import java.util.Date;

public class User {
	
	private String name;
	private Date dob;

	

	public void setName(String name) {
		this.name = name;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", dob=" + dob + "]";
	}
	
	public void initialize() {
		System.out.println("init method invoked");
		if(dob==null) {
			throw new IllegalArgumentException("DOB cannot be null");
		}
	}
	
	public void myDestroy() {
		System.out.println("destroy method invoked");
		name=null;
		dob=null;
	}
	
	
	

}
