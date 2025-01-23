package com.springrest.app.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.app.entity.Address;
import com.springrest.app.entity.StudentEntity;

@RestController
@RequestMapping("/student")
public class StudentRestController {
	
	@PostMapping("/data")
	public String getDataFromRequestBody(@RequestBody StudentEntity studentEntity) {
		return "Student data is : " + studentEntity;
	}
	
	
	
	@GetMapping("/get-student-data/{id}")
	public String showStudentData(@PathVariable Integer id) {
		if(id==10) {
			return "Student: Ankit";
		}
		else if(id==9) {
			return "Student: Amit";
		}
		return "Student Not Found With The Given Id";
	}
	
	
	@GetMapping("/get-student_by_class/{sclass}/{rollNo}")
	public String getStudentDataFromClass(
			@PathVariable Integer rollNo, 
			@PathVariable Integer sclass
										 ) {
		
		return "Student class : "+ sclass+ " | Roll no : " + rollNo; 
	}
	
	
	
	
	@GetMapping("/delete/sid")
	public String deleteStudent2() {
		return "[static path] student deleted with id";
	}
	

	@GetMapping("/delete/{sid}")
	public String deleteStudent(@PathVariable Integer sid) {
		return "student deleted with id : "+ sid ;
	}
	
	
	
	
	
}
