package com.employee.app.service;

import java.util.List;

import com.employee.app.dto.EmployeeDto;

public interface EmployeeService {
	
	public List<EmployeeDto> getAllEmployees();
	
	public List<EmployeeDto> getAllEmployeesByCity(String city);
	
	public List<EmployeeDto> getEmployeesBySalaryRange(Float minSal, Float maxSal);

    public List<Object[]> getEmpDetailsByCities(String city1, String city2, String city3);

    public List<Object[]> getEmpDetailsByInitialNameLetters(String initialLetters);
}
