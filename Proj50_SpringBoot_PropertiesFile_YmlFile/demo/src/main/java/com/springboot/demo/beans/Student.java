package com.springboot.demo.beans;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("student")
@ConfigurationProperties(prefix = "student.info")
public class Student {
	
	@Value("${user.info.id}")
	private int id;
	
	@Value("${user.info.email}")
	private String email;
	
	@Value("${user.info.name}")
	private String name;
	
	
	private int[] marks;
	
	private List subjects;
	
	private Set extraActivities;
	
	private Map<String, Long> contactNo;
	
	private PlacementChoice placementChoice;
	
	
	

	public PlacementChoice getPlacementChoice() {
		return placementChoice;
	}

	public void setPlacementChoice(PlacementChoice placementChoice) {
		this.placementChoice = placementChoice;
	}

	public Map<String, Long> getContactNo() {
		return contactNo;
	}

	public void setContactNo(Map<String, Long> contactNo) {
		this.contactNo = contactNo;
	}

	public Set getExtraActivities() {
		return extraActivities;
	}

	public void setExtraActivities(Set extraActivities) {
		this.extraActivities = extraActivities;
	}

	public List getSubjects() {
		return subjects;
	}

	public void setSubjects(List subjects) {
		this.subjects = subjects;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getMarks() {
		return marks;
	}

	public void setMarks(int[] marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", email=" + email + ", name=" + name + ", marks=" + Arrays.toString(marks)
				+ ", subjects=" + subjects + ", extraActivities=" + extraActivities + ", contactNo=" + contactNo
				+ ", placementChoice=" + placementChoice + "]";
	}

	
	

	
	
	

}
