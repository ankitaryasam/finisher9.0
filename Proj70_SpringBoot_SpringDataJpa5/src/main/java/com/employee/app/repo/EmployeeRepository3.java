package com.employee.app.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.app.entity.EmployeeEntity;
import com.employee.app.view.View;

@Repository("empRepo3")
public interface EmployeeRepository3 extends JpaRepository<EmployeeEntity, Integer>  {
   
	public List<ResultView> findByCityIn(Collection<String> cities);
	
	
	public <T extends View> List<T> findByCity(String city, Class<T> clazz);
	
}

