package com.app.beans;

import java.util.Date;
import java.util.List;

public class Faculty {
	
	private List<String> name;
	private List<Date> joiningDate;
	
	public void setName(List<String> name) {
		this.name = name;
	}
	public void setJoiningDate(List<Date> joiningDate) {
		this.joiningDate = joiningDate;
	}
	@Override
	public String toString() {
		System.out.println(name.getClass().getName());
		return "Faculty [name=" + name + ", joiningDate=" + joiningDate + "]";
	}
	
	

}
