package com.student.service;

import com.student.dto.StudentDto;

public interface StudentService {
	
	public StudentDto getStudentDetailsById(int id) throws Exception;

}
