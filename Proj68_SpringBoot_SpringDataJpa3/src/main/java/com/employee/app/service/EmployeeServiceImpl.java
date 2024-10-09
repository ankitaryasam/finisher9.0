package com.employee.app.service;




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.app.dto.EmployeeDto;
import com.employee.app.entity.EmployeeEntity;
import com.employee.app.repo.EmployeeRepo;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service("empService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;
	
	
	@Override
	public List<EmployeeDto> getAllEmployees(String property, boolean ascendingOrder) {
		/*
		Sort sort = null;
		if(ascendingOrder) {
			sort = Sort.by(Sort.Direction.ASC, property);
		}
		else {
			sort = Sort.by(Sort.Direction.DESC, property);
		}
		*/
		
		
		 List<EmployeeEntity> entityList = (List<EmployeeEntity>)empRepo.findAll(
                  ascendingOrder?Sort.by(Sort.Direction.ASC, property):Sort.by(Sort.Direction.DESC, property)
				 );
		 
		 //convert the entity list to the dto list
		 List<EmployeeDto> dtoList = new ArrayList<EmployeeDto>();
		 
		 entityList.forEach(entity ->{
			 EmployeeDto dto = new EmployeeDto();
			 BeanUtils.copyProperties(entity, dto);
			 dtoList.add(dto);
		 });
		
		 return dtoList;
	}


	@Override
	public List<EmployeeDto> getAllEmployees(boolean ascendingOrder, String... properties) {

		 List<EmployeeEntity> entityList = (List<EmployeeEntity>)empRepo.findAll(
                 ascendingOrder?Sort.by(Sort.Direction.ASC, properties):Sort.by(Sort.Direction.DESC, properties)
				 );
		 
		 //convert the entity list to the dto list
		 List<EmployeeDto> dtoList = new ArrayList<EmployeeDto>();
		 
		 entityList.forEach(entity ->{
			 EmployeeDto dto = new EmployeeDto();
			 BeanUtils.copyProperties(entity, dto);
			 dtoList.add(dto);
		 });
		
		 return dtoList;
	}


	@Override
	public List<EmployeeDto> getPageRecords(int pageNo, int pageSize) {
		
		//create the pageable object having input of pageNo and pageSize
		
		Pageable pageable = PageRequest.of(pageNo, pageSize, Direction.DESC, "salary");
		
		//get the page object by calling findAll(--) method of PagingAndSortingRepository(I)
		
		Page<EmployeeEntity> page = empRepo.findAll(pageable);
		
		System.out.println("------other informations that a page has-----------------");
		
		System.out.println(page.getNumber() + " " + page.getNumberOfElements() + " " + page.getTotalPages());
	
		
	    System.out.println(page.isEmpty() + " " + page.isFirst() + " " + page.isLast());
	
	    
	    //get the entity list from the Page<T>
	    
	    List<EmployeeEntity> entityList = page.getContent();
	    
	    //convert the entity list to dto list
	    
	    List<EmployeeDto> dtoList = new ArrayList<EmployeeDto>();
	    
	    entityList.forEach(entity->{
	    	EmployeeDto dto = new EmployeeDto();
	    	BeanUtils.copyProperties(entity, dto);
	    	dtoList.add(dto);
	    });
	
	    return dtoList;
	
	
	}


	@Override
	public void getRecordsByPagination(int pageSize) {
		
		
		//get the total no of records
		long totalRecords = empRepo.count();
		
		//get the total no of pages
		int pagesCount = (int)(totalRecords / pageSize);
		
		if(totalRecords % pageSize != 0)
			pagesCount++;
		
		//displaying records by page
		
		for(int i=0; i<pagesCount; i++) {
			Pageable pageable = PageRequest.of(i, pageSize);
			Page<EmployeeEntity> page = empRepo.findAll(pageable);
			List<EmployeeEntity> entityList = page.getContent();
			entityList.forEach(System.out::println);
			System.out.println(page.getNumber() + 1 + "  of " + page.getTotalPages());
			System.out.println("--------------------------------");
		}
		
		
		
	}


	@Override
	@Transactional
	public EmployeeDto fetchEmployeeById(int eid) {
		EmployeeEntity entity = empRepo.getReferenceById(eid);
		
		//convert the entity to dto
		EmployeeDto dto = new EmployeeDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


	@Override
	public void removeEmployeesInBatch(List<EmployeeDto> listDto) {
		//convert the dto to entity list
		
		List<EmployeeEntity> listEntity = new ArrayList<EmployeeEntity>();
		
		listDto.forEach(dto->{
			EmployeeEntity entity = new EmployeeEntity();
			BeanUtils.copyProperties(dto, entity);
			listEntity.add(entity);
		});
		
		empRepo.deleteAllInBatch(listEntity);
		
	}
 
	
	
	
	
	
	
	
	
	
	
	
	
}
