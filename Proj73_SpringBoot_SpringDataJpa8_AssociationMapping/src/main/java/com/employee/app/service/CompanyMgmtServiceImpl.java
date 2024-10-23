package com.employee.app.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.app.entity.DepartmentEntity;
import com.employee.app.entity.EmployeeEntity;
import com.employee.app.repo.DepartmentRepo;
import com.employee.app.repo.EmployeeRepo;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@Service
public class CompanyMgmtServiceImpl implements CompanyMgmtService {

	@Autowired
	private EmployeeRepo empRepo;
	
	@Autowired
	private DepartmentRepo departmentRepo;
	
	
	@Override
	public void saveDataUsingParent() {
		
	//child objects
		EmployeeEntity e1 = new EmployeeEntity("Animesh Ranjan", "animesh@gmail.com", 100000.00f, "Patna");
		EmployeeEntity e2 = new EmployeeEntity("Priya Raj", "priya@gmail.com", 120000.00f, "Patna");
		
		
		
		DepartmentEntity departmentEntity = new DepartmentEntity();
		departmentEntity.setName("Sales");
		departmentEntity.setDeptLocation("Patna");
		departmentEntity.setEmployees(Set.of(e1, e2));
		
		//department is parent
		departmentRepo.save(departmentEntity);

	}

	@Override
	public void saveDataUsingChilds() {
		// create childs
		EmployeeEntity e1 = new EmployeeEntity("Suresh Ranjan", "suresh@gmail.com", 10000.00f, "Delhi");
		EmployeeEntity e2 = new EmployeeEntity("Priyam Jaiswal", "priyam@gmail.com", 45000.00f, "Delhi");
		
		
		//create the parent object
		DepartmentEntity dept = new DepartmentEntity();
		dept.setName("Accounts");
		dept.setDeptLocation("Noida");

		dept.setEmployees(Set.of(e1, e2));
		
		e1.setDept(dept);
		e2.setDept(dept);
		
		//save data using childs
		
		//use repo to save
		empRepo.save(e1);
		empRepo.save(e2);
		
	}

	@Override
	@Transactional
	public void getDataUsingParent() {
	
		// using parent
		
		List<DepartmentEntity> deptList = departmentRepo.findAll();
		deptList.forEach(dept->{
			System.out.println("parent :: " + dept.getName());
//			Set<EmployeeEntity> childs =  dept.getEmployees();	
//			System.out.println("child count : " + childs.size());
			System.out.println("...................");
		});
		
		
	}

	@Override
	@Transactional
	public void getDataUsingChilds() {
	
		List<EmployeeEntity> empList = empRepo.findAll();
		empList.forEach(emp->{
			System.out.println(emp.getName());
			System.out.println(emp.getDept().getName());
		});

	}

}
