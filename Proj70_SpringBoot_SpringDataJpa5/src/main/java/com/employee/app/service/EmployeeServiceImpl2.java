package com.employee.app.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.employee.app.repo.EmployeeRepository3;
import com.employee.app.repo.ResultView;
import com.employee.app.view.ResultView1;
import com.employee.app.view.ResultView2;
import com.employee.app.view.ResultView3;

@Service("empService2")
public class EmployeeServiceImpl2  implements EmployeeService{
    
	@Autowired
	@Qualifier("empRepo3")
	private EmployeeRepository3 empRepo;

	@Override
	public List<ResultView> getEmployeesDataByCities(Collection<String> cities) {
	
		return empRepo.findByCityIn(cities);
		
	}

	@Override
	public List<ResultView1> getEmpData1(String city) {
		return empRepo.findByCity(city, ResultView1.class);
	}

	@Override
	public List<ResultView2> getEmpData2(String city) {
		return empRepo.findByCity(city, ResultView2.class);
	}

	@Override
	public List<ResultView3> getEmpData3(String city) {
		return empRepo.findByCity(city, ResultView3.class);
	}
	
	

	
}
