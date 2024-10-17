package com.employee.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employee.app.entity.EmployeeEntity;

@Repository("empRepo")
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer>{
  
	
	//query methods
	
	// list of all employees :: employee entity
//	@Query("FROM EmployeeEntity e")
//	@Query("SELECT e FROM EmployeeEntity e")
	@Query("FROM com.employee.app.entity.EmployeeEntity")
	public List<EmployeeEntity> fetchAllEmployees();
	
//	@Query("FROM EmployeeEntity WHERE city=?1")
	@Query("FROM EmployeeEntity WHERE city=:city")
	public List<EmployeeEntity> fetchAllEmployeesByCity(@Param("city") String city);
	
	@Query("FROM EmployeeEntity where salary>=:min AND salary<=:max")
	public List<EmployeeEntity> fetchAllEmployeesBySalaryRange(Float min, Float max);
	
	
	//retrieving specific multiple column values (scalar projections)
	
	@Query("SELECT eid, name, email FROM EmployeeEntity WHERE city in(:city1, :city2, :city3)")
	public List<Object[]> fetchEmpDetailsByCities(String city1, String city2, String city3);
	
	@Query("SELECT eid, name FROM EmployeeEntity where name like :initialLetters%")
	public List<Object[]> fetchEmpDetailsByInitialNames(String initialLetters);
}
