package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.student.dto.StudentDto;
import com.student.service.StudentService;

@Controller("controller")
public class StudentMainController {
	
	
	@Autowired
	private StudentService studentService;

	
	public String fetchStudentName(int id) throws Exception{
		return studentService.getStudentName(id);
	}
	
	public List<StudentDto> fetchStudentDetailsByCourse(String course1, String course2, String course3) throws Exception{
		return studentService.getStudentDetailsByCourse(course1, course2, course3);
	}
	
	public int processNewStudentRegistration(StudentDto dto) throws Exception {
		return studentService.registerNewStudent(dto);	
	}
}
