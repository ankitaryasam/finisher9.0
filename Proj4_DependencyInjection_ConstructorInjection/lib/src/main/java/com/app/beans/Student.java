package com.app.beans;

// target spring bean class
public class Student {
	
	//bean properties
	private String name;
	private int roll;
	private Course course;
	
	
    public Student(String name, int roll, Course studentCourse) {
    	System.out.println("this is 3-param constructor");
    	this.name=name;
    	this.roll=roll;
    	this.course=studentCourse;
    }
    
    
    public void startMyCourse() {
    	course.startCourse();
    }

	@Override
	public String toString() {
		return "Student [name=" + name + ", roll=" + roll + ", course=" + course + "]";
	}

	
    
    

}
