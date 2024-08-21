package com.student.controller;

import java.util.ArrayList;
import java.util.List;

import com.student.dto.StudentDto;
import com.student.service.StudentService;
import com.student.vo.StudentVo;

public class StudentMainAppController {
	
	private StudentService studentService;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	public int fetchTotalNoOfStudents() throws Exception{
	
		return studentService.getTotatNoOfStudents();
		
		
	}

}
