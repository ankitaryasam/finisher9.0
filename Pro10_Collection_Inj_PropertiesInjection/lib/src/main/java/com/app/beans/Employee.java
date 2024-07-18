package com.app.beans;

import java.util.Properties;

public class Employee {
	
	private Properties employeeDesignation;

	public void setEmployeeDesignation(Properties employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	@Override
	public String toString() {
		return "Employee [employeeDesignation=" + employeeDesignation + "]";
	}
	
	
	
	

}
