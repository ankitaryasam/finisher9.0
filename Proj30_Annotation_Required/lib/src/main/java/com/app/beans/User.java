package com.app.beans;

import java.util.Date;

import org.springframework.beans.factory.annotation.Required;

public class User {
	
	
	private String name;
	private String email;
	private Date dob;
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Required  
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", dob=" + dob + "]";
	}
	
	
	

}
