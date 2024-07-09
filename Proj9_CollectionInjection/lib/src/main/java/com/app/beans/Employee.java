package com.app.beans;

import java.util.Date;
import java.util.ArrayList;
import java.util.LinkedList;

public class Employee {
	
	private LinkedList<String> name;
	private ArrayList<Date> joiningDate;
	
	public void setName(LinkedList<String> name) {
		this.name = name;
	}
	public void setJoiningDate(ArrayList<Date> joiningDate) {
		this.joiningDate = joiningDate;
	}
	@Override
	public String toString() {
		System.out.println(name.getClass().getName());
		return "Employee [name=" + name + ", joiningDate=" + joiningDate + "]";
	}
	
	

}
