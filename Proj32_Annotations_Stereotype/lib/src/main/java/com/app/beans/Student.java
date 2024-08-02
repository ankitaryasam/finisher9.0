package com.app.beans;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

@Component("myStudent")
public class Student {
	
	private String name;
	
	public Student() {
		System.out.println("Student.Student()");
	}
	
	public void setName(String name) {
		this.name=name;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}

	
	
}
