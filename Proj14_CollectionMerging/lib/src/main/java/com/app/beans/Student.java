package com.app.beans;

import java.util.Set;

public class Student {
	
	private Set<String> subjects;
	
	public Student() {
		System.out.println("constructor---Student()");
	}

	public void setSubjects(Set<String> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Student [subjects=" + subjects + "]";
	}
	
	
	

}
