package com.app.beans;

import java.util.Date;

public class Student {
	
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
		return "Student [name=" + name + ", dob=" + dob + "]";
	}
	

	public void myinit() {
		System.out.println("init invoked---student");
	}
	
	public void mydestroy() {
		System.out.println("destroy invoked---student");
	}

}
