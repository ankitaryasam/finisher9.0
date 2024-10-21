package com.employee.app.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.app.entity.DepartmentEntity;
import com.employee.app.entity.EmployeeEntity;
import com.employee.app.repo.DepartmentRepo;
import com.employee.app.repo.EmployeeRepo;

@Service
public class CompanyMgmtServiceImpl implements CompanyMgmtService {

	@Autowired
	private EmployeeRepo empRepo;
	
	@Autowired
	private DepartmentRepo departmentRepo;
	
	
	@Override
	public void saveDataUsingParent() {
		
	//child objects
		EmployeeEntity e1 = new EmployeeEntity("Amit Kumar", "amit@gmail.com", 100000.00f, "Patna");
		EmployeeEntity e2 = new EmployeeEntity("Shubham Kumar", "shubham@gmail.com", 120000.00f, "Patna");
		
		
		
		DepartmentEntity departmentEntity = new DepartmentEntity();
		departmentEntity.setName("IT");
		departmentEntity.setDeptLocation("Bangalore");
		departmentEntity.setEmployees(Set.of(e1, e2));
		
		//department is parent
		departmentRepo.save(departmentEntity);

	}

	@Override
	public void saveDataUsingChilds() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getDataUsingParent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getDataUsingChilds() {
		// TODO Auto-generated method stub

	}

}
