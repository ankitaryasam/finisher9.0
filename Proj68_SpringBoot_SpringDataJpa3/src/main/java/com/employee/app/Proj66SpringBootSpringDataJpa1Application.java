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
	
	
	controller.getAllEmployeesInSortingOrder("salary", false);

	controller.getAllEmployeesInSortingOrderByMultipleProperties(true, "salary", "eid");
	
	
	controller.getEmployeesByPageNumber(5, 3);
	
	System.out.println("------------by pagination in standalone env-------------");
	controller.fetchEmployeeDataByPagination(3);
	
	System.out.println("----------------");
	controller.getEmployeeById(1020);
	
	
	controller.deleteEmployeesInBatch(List.of(
			 new EmployeeDto(1001),
			 new EmployeeDto(1002),
			 new EmployeeDto(1003),
			 new EmployeeDto(1020)
			));
	
	
	}
	
	
	

}
