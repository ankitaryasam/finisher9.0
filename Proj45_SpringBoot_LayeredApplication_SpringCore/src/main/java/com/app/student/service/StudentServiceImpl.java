package com.app.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.student.dao.StudentDao;
import com.app.student.dto.StudentDto;
import com.app.student.entity.StudentEntity;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	
	private StudentDao studentDao;
	
	
    @Autowired
	public StudentServiceImpl(@Qualifier("studentDao") StudentDao studentDao) {
		this.studentDao = studentDao;
	}



	@Override
	public int registerNewStudent(StudentDto dto) throws Exception {
		StudentEntity entity = null;
		String grade = null;
		
		//converting dto to entity
		entity = new StudentEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setCourseName(dto.getCourseName());
		entity.setObtMarks(dto.getObtMarks());
		
		//calculate gradle
		if(dto.getObtMarks() >= 400) {
			grade = "A";
		}
		else if(dto.getObtMarks() >= 350) {
			grade="B";
		}
		else if(dto.getObtMarks() >= 300) {
		    grade="C";
		}
		else if(dto.getObtMarks() >= 200) {
			grade="D";
		}
		else {
			grade="Fail";
		}
		
		dto.setGrade(grade);
		entity.setGrade(dto.getGrade());
		int i = studentDao.saveStudent(entity);
		return i;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
