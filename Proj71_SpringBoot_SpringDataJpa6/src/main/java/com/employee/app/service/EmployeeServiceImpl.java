package com.employee.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.app.dto.EmployeeDto;
import com.employee.app.entity.EmployeeEntity;
import com.employee.app.repo.EmployeeRepo;

@Service("empService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	
	@Override
	public List<EmployeeDto> getAllEmployees() {
		//call the repo methods...
		
		List<EmployeeEntity> entityList = employeeRepo.fetchAllEmployees();
		List<EmployeeDto> dtoList = new ArrayList<EmployeeDto>();
		entityList.forEach(entity->{
			EmployeeDto dto = new EmployeeDto();
			BeanUtils.copyProperties(entity, dto);
			dtoList.add(dto);
		});
		
		return dtoList;
		
	}


	@Override
	public List<EmployeeDto> getAllEmployeesByCity(String city) {

		List<EmployeeEntity> entityList = employeeRepo.fetchAllEmployeesByCity(city);
		List<EmployeeDto> dtoList = new ArrayList<EmployeeDto>();
		entityList.forEach(entity->{
			EmployeeDto dto = new EmployeeDto();
			BeanUtils.copyProperties(entity, dto);
			dtoList.add(dto);
		});
		
		return dtoList;
	}


	@Override
	public List<EmployeeDto> getEmployeesBySalaryRange(Float minSal, Float maxSal) {
		
		List<EmployeeDto> dtoList = new ArrayList<EmployeeDto>();
		employeeRepo.fetchAllEmployeesBySalaryRange(minSal, maxSal)
		             				.forEach(entity->{
		             					EmployeeDto dto = new EmployeeDto();
		             					BeanUtils.copyProperties(entity, dto);
		             					dtoList.add(dto);
		             				});
		return dtoList;
	}


	@Override
	public List<Object[]> getEmpDetailsByCities(String city1, String city2, String city3) {
		return employeeRepo.fetchEmpDetailsByCities(city1, city2, city3);
	}


	@Override
	public List<Object[]> getEmpDetailsByInitialNameLetters(String initialLetters) {
		return employeeRepo.fetchEmpDetailsByInitialNames(initialLetters);
	}

}
