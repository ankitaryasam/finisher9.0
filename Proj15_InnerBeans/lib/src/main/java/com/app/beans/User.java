package com.app.beans;

public class User {
	
	
   private Phone phone;
   
   public User(Phone phone) {
	   this.phone=phone;
   }

@Override
public String toString() {
	return "User [phone=" + phone + "]";
}
   
   
   
}
