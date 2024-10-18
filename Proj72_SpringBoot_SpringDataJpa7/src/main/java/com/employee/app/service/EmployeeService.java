package com.employee.app.service;

import java.util.List;

import com.employee.app.dto.EmployeeDto;

public interface EmployeeService {
	
	public List<EmployeeDto> getAllEmployees();
	
	public List<EmployeeDto> getAllEmployeesByCity(String city);
	
	public List<EmployeeDto> getEmployeesBySalaryRange(Float minSal, Float maxSal);

    public List<Object[]> getEmpDetailsByCities(String city1, String city2, String city3);

    public List<Object[]> getEmpDetailsByInitialNameLetters(String initialLetters);

    public List<String> getEmpNamesByEidRange(int start, int end);

    
    public int updateEmployeeSalaryById(Integer id, Float newSalary);
    
    public int deleteEmployeeHavingNoAddress();
    
    public int registerEmployee(Integer eid, String email, String name, Float salary, String city);
}
