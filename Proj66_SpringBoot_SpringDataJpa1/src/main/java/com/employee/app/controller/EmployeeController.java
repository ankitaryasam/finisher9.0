package com.employee.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.employee.app.dto.EmployeeDto;
import com.employee.app.service.EmployeeService;

@Controller("empController")
public class EmployeeController {
	
    @Autowired
	private EmployeeService empService;
    
    
    public void processEmployeeRegRequest(EmployeeDto empDto) {
    	Integer eid = null;
    	//call the service method
    	
    	eid = empService.registerEmployee(empDto);
    	
    	if(eid!=null) {
    		System.out.println("employee registration successfull!");
    	}
    	else {
    		System.out.println("employee registration failed!");
    	}
    	
    	
    	
    }
    
    
    public Integer[] processEmpRegInGroup(List<EmployeeDto> empDtoList) {
    	return empService.registerEmployeeInGroup(empDtoList);
    }
    
    public long getTotalEmployeeRecordCount() {
    	return empService.getTotalNoOfEmployees();
    }
    
    public boolean isEmployeeRegisterd(Integer id) {
    	return empService.isEmployeeExist(id);
    }
    
    public void processDeleteEmployee(Integer id) {
    	empService.deleteEmployeeById(id);
    }
    
    //using for Optional
    public void checkEmployee(Integer id) {
    	Optional<EmployeeDto> optionalDto = empService.getEmployeeById(id);
    	
    	if(optionalDto.isPresent()) {
    		System.out.println("Employee is present : " + optionalDto.get());
    	}
    	else {
    		System.out.println("Employee not found");
    	}
    }
    
    
    public void deleteEmployee(int id) {
    	String status = empService.deleteEmployeeById(id);
    	System.out.println(status);
    }
    
    
    public void getAllEmployees() {
    	List<EmployeeDto> dtoList = empService.getAllEmployees();
    	System.out.println(dtoList);
    }
    
    public void deleteAllGivenEntities(List<EmployeeDto> dtoList) {
    	String status = empService.removeEmployeesByGivenEntities(dtoList);
    	System.out.println(status);
    }
    
    
    
    
    
    
    public void getAllEmployeesByIds(List<Integer> ids) {
    	List<EmployeeDto> dtoList = empService.getEmployeesByIds(ids);
    	System.out.println(dtoList);
    }
    
    
    
    
    
    
    
    
    
}
