package com.app.beans;

//dependent spring bean class
public class Course {
	
	private String name;
	
	public Course() {
		System.out.println("Course.Course()");
	}
	
	public void setName(String name) {
		this.name = name;
	}



	public void startCourse() {
		System.out.println("course is loading....");
	}
	

}
