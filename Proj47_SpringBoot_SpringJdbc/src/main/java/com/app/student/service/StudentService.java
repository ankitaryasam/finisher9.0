package com.app.student.service;

import java.util.List;
import java.util.Map;

public interface StudentService {
	
	public int getTotatNoOfStudents() throws Exception;
	public String getStudentName(int id) throws Exception;
	public Map<String, Object> getStudentDetails(int id) throws Exception;
    public List<Map<String, Object>> getAllStudentsByCourse(String course) throws Exception;
    
    
}
