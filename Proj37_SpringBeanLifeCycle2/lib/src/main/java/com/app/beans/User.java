package com.app.beans;

import java.util.Date;

public class User {
	
	private String name;
	private Date regDate;
	public void setName(String name) {
		this.name = name;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", regDate=" + regDate + "]";
	}
	

	public void myinit() {
		System.out.println("init invoked---user");
	}
	
	public void mydestroy() {
		System.out.println("destroy invoked---user");
	}

}
