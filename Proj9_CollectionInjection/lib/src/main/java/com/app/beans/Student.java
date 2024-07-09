package com.app.beans;

import java.util.Arrays;

public class Student {
	
	private String name;
	private Integer[] marks;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setMarks(Integer[] marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		
		return "Student [name=" + name + ", marks=" + Arrays.toString(marks) + "]";
	}
	
	
	

}
