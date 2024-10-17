package com.employee.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.employee.app.service.EmployeeService;

@Controller("empController")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	public void getAllRegisteredEmployees() {
		System.out.println(empService.getAllEmployees());
	}
	
	public void getAllRegisteredEmployeesByCity(String city) {
		System.out.println(empService.getAllEmployeesByCity(city));
	}
	
	public void getEmployeesBySalaryRange(Float minSal, Float maxSal) {
		System.out.println(empService.getEmployeesBySalaryRange(minSal, maxSal));
	}
	
	public void getEmpDetailsByCities(String city1, String city2, String city3) {
		List<Object[]> empDetails = empService.getEmpDetailsByCities(city1, city2, city3);
		
		empDetails.forEach(row->{
			System.out.println(row[0] + "  " + row[1] + "  " + row[2] );
		});
		
		
	}
	
	public void getEmpDetailsByInitialNameLetters(String name) {
		List<Object[]> empDetails = empService.getEmpDetailsByInitialNameLetters(name);
		
		empDetails.forEach(row->{
			System.out.println(row[0] + "  " + row[1]);
		});
		
		
	}
    
}
