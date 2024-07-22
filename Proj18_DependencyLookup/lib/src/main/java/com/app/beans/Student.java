package com.app.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// target spring bean class
public class Student {
	
	private String stuName;
	
	//for this object we will do dependency lookup
	private ZoomStreamingApi zoomApi;
	
	
	
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}


	public void markAttendance() {
		System.out.println("attendance done");
	}
	
	public void giveTest() {
		System.out.println("test is started");
	}
	
	public void viewExamResult() {
		System.out.println("Last semested result : ");
	}
	
	public void startOnlineLiveClass() {
		//here zoomStreaming will be used...
		
		ApplicationContext context = null;
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		zoomApi = context.getBean("zoomApi", ZoomStreamingApi.class);
		
		//using zoomStreamingApi object
		zoomApi.streamVideoClassOnline();
		
	}

	@Override
	public String toString() {
		return "Student [stuName=" + stuName + "]";
	}

	
	
	
	

}
