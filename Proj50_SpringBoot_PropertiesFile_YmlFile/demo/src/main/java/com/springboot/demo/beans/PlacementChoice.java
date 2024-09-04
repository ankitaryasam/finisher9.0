package com.springboot.demo.beans;

import java.util.List;

public class PlacementChoice {
	
	private List compName;
	private float salary;
	
	
	
	public List getCompName() {
		return compName;
	}
	public void setCompName(List compName) {
		this.compName = compName;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "PlacementChoice [compName=" + compName + ", salary=" + salary + "]";
	}
	
	
	

}
