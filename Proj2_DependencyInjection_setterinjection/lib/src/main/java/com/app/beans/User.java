package com.app.beans;

//spring bean class
public class User {
	
	//bean properties
	private String name;
	private String email;
	private String pass;
	
	public void setName(String name) {
		System.out.println("User.setName()");
		this.name=name;
	}
	
	public void setEmail(String email) {
		System.out.println("User.setEmail()");
		this.email=email;		
	}
	
	public void setPass(String pass) {
		System.out.println("User.setPass()");
		this.pass=pass;
	}
	
	
	public User() {
		System.out.println("User.User()");
	}
	
	public void showUserInfo() {
		System.out.println(name + "    "  + email + "    " + pass);
	}
	

}
