package com.springrest.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentRestController {
	
	@GetMapping("/get")
	public ResponseEntity<String> getStudent(){
		ResponseEntity<String> response = 
				new ResponseEntity<String>("STUDENT-ANKIT", HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(){
		ResponseEntity<String> response = new ResponseEntity<String>("NEW-STUDENT-SAVED", HttpStatus.CREATED);
		return response;
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateStudent() {
//		ResponseEntity<String> response = new ResponseEntity<String>("STUDENT-UPDATED", HttpStatus.RESET_CONTENT);
		ResponseEntity<String> response = new ResponseEntity<String>("STUDENT-UPDATED", HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteStudent() {
		ResponseEntity<String> response = new ResponseEntity<String>("STUDENT-DELETED", HttpStatus.OK);
		return response;
	}
	
}
