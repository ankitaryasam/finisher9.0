package com.app.student.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.app.student.service.StudentService;

@Controller("controller")
public class StudentMainAppController {
	
	@Autowired
	@Qualifier("studentService")
	private StudentService studentService;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	
	public String fetchStudentName(int id) throws Exception {
		return studentService.getStudentName(id);
	}
	
	public List<Map<String, Object>> fetchAllStudentsByCourseName(String courseName) throws Exception {
		return studentService.getAllStudentsByCourse(courseName);
	}
	
	public Map<String, Object> fetchStudentDetails(int id) throws Exception {
		return studentService.getStudentDetails(id);
	}
	
	public int fetchTotalNoOfStudents() throws Exception{
	
		return studentService.getTotatNoOfStudents();
		
		
	}

}
