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
	
	
     // inserting single record
//	controller.processEmployeeRegRequest(dto);
	
	
	//inserting record in a batch
	
    /*
	Integer[] ids = controller.processEmpRegInGroup(
           List.of(new EmployeeDto(1004, "Pritam Raj", "prt@gmail.com", 10000.00f),
        		    new EmployeeDto(1005, "Riya Rani", "riya@gmail.com", 12000.00f),
        		    new EmployeeDto(1006, "Venkatesh Raj", "vnk@gmail.com", 15000.00f),
        		    new EmployeeDto(1007, "Paresh Rawal", "prrw@gmail.com", 16000.00f)
        		   )
			);
			
			
	
	System.out.println("saved ids : " + Arrays.toString(ids));
	
	*/
	
	
	//getting the record count
    long totalEmployees = controller.getTotalEmployeeRecordCount();
    System.out.println("Total no. of registered emp is : " + totalEmployees);
	
	//check the entity available or not
    boolean emp = controller.isEmployeeRegisterd(1005);
    if(emp) {
    	System.out.println("Employee with the given id is registered");
	}
	else {
		System.out.println("Employee with given id is not registerd");
	}
		
	
    //deleting the entity or record
//    controller.processDeleteEmployee(1007);
	
	
    //using the optional findById...
    controller.checkEmployee(1007);
    
	}
	

}
