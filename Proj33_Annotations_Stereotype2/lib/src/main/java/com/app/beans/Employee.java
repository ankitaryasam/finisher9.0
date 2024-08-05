package com.app.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Lazy(false)
@Scope("prototype")
public class Employee {
	
	public Employee() {
		System.out.println("Employee.Employee()");
	}

}
