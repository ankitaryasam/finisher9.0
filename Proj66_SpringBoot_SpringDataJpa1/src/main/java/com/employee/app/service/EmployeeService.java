package com.employee.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.app.dto.EmployeeDto;
import com.employee.app.repo.EmployeeRepo;

public interface EmployeeService {

	
	public Integer registerEmployee(EmployeeDto empDto);
	
	public Integer[] registerEmployeeInGroup(List<EmployeeDto> listEmpDto);
	
	public long getTotalNoOfEmployees();
	
	public boolean isEmployeeExist(Integer id);
	
	public void deleteEmployeeById(Integer id);
	
	public Optional<EmployeeDto> getEmployeeById(Integer id);
	
	public String deleteEmployeeById(int id);
	
	public List<EmployeeDto> getAllEmployees();
	
	public String removeEmployeesByGivenEntities(List<EmployeeDto> empDtoList);

	
	public List<EmployeeDto> getEmployeesByIds(List<Integer> ids);
	
	
	
	
	
	
	
	
	
	
	
}
