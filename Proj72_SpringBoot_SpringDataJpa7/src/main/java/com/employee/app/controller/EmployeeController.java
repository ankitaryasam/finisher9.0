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
	
	
	public void showEmployeeNamesByEidRange(int startRange, int endRange) {
		System.out.println(empService.getEmpNamesByEidRange(startRange, endRange));
	}

	public void updateEmployeeSalaryById(Integer id, Float newSalary) {
		System.out.println(empService.updateEmployeeSalaryById(id, newSalary));
	}
	
	public void removeEmployeeHavingNoAddress() {
		System.out.println(empService.deleteEmployeeHavingNoAddress());
	}
	
	
	public void registerNewEmployee(Integer eid, String email, String name, Float salary, String city) {
		int rowAffected = empService.registerEmployee(eid, email, name, salary, city);
		if(rowAffected > 0) {
			System.out.println("record saved successfully");
		}
		else {
			System.out.println("record not saved!");
		}
	}
	
	
	
	
	
	
	
	
	
}
