package com.app.beans;

public class User {
	
	private User() {
		System.out.println("User.User()");
	}
	
	public void showUser() {
		System.out.println("Hello User!");
	}

}
