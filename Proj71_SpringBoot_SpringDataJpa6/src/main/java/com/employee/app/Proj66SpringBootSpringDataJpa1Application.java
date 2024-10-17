package com.employee.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.employee.app.controller.EmployeeController;
import com.employee.app.dto.EmployeeDto;


@SpringBootApplication
public class Proj66SpringBootSpringDataJpa1Application {

	public static void main(String[] args) {
		ApplicationContext context = null;
		EmployeeController controller = null;
	
		
	context =	SpringApplication.run(Proj66SpringBootSpringDataJpa1Application.class, args);
	
	controller = context.getBean("empController", EmployeeController.class);
	
	controller.getAllRegisteredEmployees();
	controller.getAllRegisteredEmployeesByCity("Patna");
	controller.getEmployeesBySalaryRange(50000.00f, 120000.00f);
	System.out.println("------------------");
	controller.getEmpDetailsByCities("Delhi", "Patna", "Kolkata");
	
	controller.getEmpDetailsByInitialNameLetters("pri");
	}
	
	
	

}
