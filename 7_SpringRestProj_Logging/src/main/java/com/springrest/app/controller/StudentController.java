package com.springrest.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.app.entity.StudentEntity;
import com.springrest.app.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/register-student")
	public ResponseEntity<String> registerStudent(@RequestBody StudentEntity entity) {
		studentService.registerNewStudent(entity);
		
		ResponseEntity<String> response = 
				new ResponseEntity<String>("student saved successfully", HttpStatus.CREATED);
	
		return response;
	}
	
	
	@GetMapping("/get-all-students")
	public ResponseEntity<List<StudentEntity>> getAllStudents() {
		List<StudentEntity> studentList = studentService.getAllStudents();
		
	ResponseEntity<List<StudentEntity>> response =	new ResponseEntity<List<StudentEntity>>(studentList, HttpStatus.OK);
	
	
	return response;
	}
	

	@GetMapping("/get-student/{id}")
	public ResponseEntity<StudentEntity> getStudentById(@PathVariable Integer id){
		
		LOGGER.info("Started execution of getStudentById method");
		
		
		ResponseEntity<StudentEntity> response = null;
		try {
			StudentEntity entity = studentService.getStudentById(id);
			response = new ResponseEntity<StudentEntity>(entity, HttpStatus.OK);
			
			LOGGER.info("Student Details Fetched Successfully : {}" , id );
		}
		catch(Exception e) {
			
			LOGGER.error("Unable to Fetch Student Details---logger {}" , e.getMessage() );
			
			e.printStackTrace(); 
		}
		
		LOGGER.info("About to exit getStudentById method");
		
		return response;
	}
	
	
	@DeleteMapping("/delete-student/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id){
	String msg =	studentService.deleteStudentById(id);
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}
	
	@PutMapping("/update-student/{id}")
	public ResponseEntity<String> updateStudent(@PathVariable Integer id, 
												@RequestBody StudentEntity entity){
		
	String msg =	studentService.updateStudent(id, entity);
	
	return new ResponseEntity<String>(msg, HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
