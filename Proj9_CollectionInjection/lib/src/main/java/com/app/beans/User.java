package com.app.beans;

import java.util.Date;
import java.util.Set;

public class User {
	
	private Set<Long> phoneNumbers;
	private Set<String> emailIds;
	private Set<Date> userRegDate;
	
	
	
	
	public void setUserRegDate(Set<Date> userRegDate) {
		this.userRegDate = userRegDate;
	}
	public void setPhoneNumbers(Set<Long> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public void setEmailIds(Set<String> emailIds) {
		this.emailIds = emailIds;
	}
	@Override
	public String toString() {
		return "User [phoneNumbers=" + phoneNumbers + ", emailIds=" + emailIds + ", userRegDate=" + userRegDate + "]";
	}

	
	

}
