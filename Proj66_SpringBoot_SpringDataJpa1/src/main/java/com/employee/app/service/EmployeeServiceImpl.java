package com.employee.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.app.dto.EmployeeDto;
import com.employee.app.entity.EmployeeEntity;
import com.employee.app.repo.EmployeeRepo;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service("empService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;
	
	@Override
	public Integer registerEmployee(EmployeeDto empDto) {
			
		//convert the dto to entity
		EmployeeEntity entity = new EmployeeEntity();
		BeanUtils.copyProperties(empDto, entity);
		
		//save the entity
		EmployeeEntity savedEntity = empRepo.save(entity);
		return savedEntity.getEid();
	}

	@Override
	public Integer[] registerEmployeeInGroup(List<EmployeeDto> listEmpDto) {
		
		//convert the dto list to the entity list
		
		List<EmployeeEntity> listEntity = new ArrayList();
		
		listEmpDto.forEach(dto->{
			EmployeeEntity entity = new EmployeeEntity();
			BeanUtils.copyProperties(dto, entity);
			listEntity.add(entity);
		});
		
		//saving the record
		
		List<EmployeeEntity> savedEntityList = (List<EmployeeEntity>)empRepo.saveAll(listEntity);
		
	    Integer[] ids = new Integer[savedEntityList.size()];
	    for(int i=0; i<savedEntityList.size(); ++i) {
	    	ids[i]=savedEntityList.get(i).getEid();
	    }
		return ids;
	}

	@Override
	public long getTotalNoOfEmployees() {
		return empRepo.count();
	}

	@Override
	public boolean isEmployeeExist(Integer id) {
		return empRepo.existsById(id);
	}

	@Override
	public void deleteEmployeeById(Integer id) {
	 empRepo.deleteById(id);
	}

	@Override
	public Optional<EmployeeDto> getEmployeeById(Integer id) {
		//use the emp repo method
		
		Optional<EmployeeEntity> entityInOptional = empRepo.findById(id);
		
		Optional<EmployeeDto> optionalDto = Optional.empty();
		
		
		if(entityInOptional.isPresent()) {
			EmployeeEntity entity = entityInOptional.get();
			
			//convert entity to do
			EmployeeDto dto = new EmployeeDto();
			BeanUtils.copyProperties(entity, dto);
			
			optionalDto = Optional.of(dto);
		}
		
		return optionalDto;
		
	}
}
