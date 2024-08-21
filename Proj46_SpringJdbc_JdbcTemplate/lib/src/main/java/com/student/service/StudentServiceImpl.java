package com.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.student.dao.StudentDao;
import com.student.dto.StudentDto;
import com.student.entity.StudentEntity;

public class StudentServiceImpl implements StudentService {
	
	private StudentDao dao;
	
	

	public void setDao(StudentDao dao) {
		this.dao = dao;
	}



	@Override
	public int getTotatNoOfStudents() throws Exception {
		return dao.getTotalNoOfStudents();
	}




}
