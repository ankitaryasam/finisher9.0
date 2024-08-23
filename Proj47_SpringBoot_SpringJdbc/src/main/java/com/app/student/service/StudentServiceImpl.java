package com.app.student.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.student.dao.StudentDao;


@Service("studentService")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	@Qualifier("studentDao")
	private StudentDao dao;
	
	

	public void setDao(StudentDao dao) {
		this.dao = dao;
	}



	@Override
	public int getTotatNoOfStudents() throws Exception {
		return dao.getTotalNoOfStudents();
	}
	
	public String getStudentName(int id) throws Exception {
		return dao.getStudentNameById(id);
	}



	@Override
	public Map<String, Object> getStudentDetails(int id) throws Exception {
		return dao.getStudentDetailsById(id);
	}



	@Override
	public List<Map<String, Object>> getAllStudentsByCourse(String course) throws Exception {
		return dao.getAllStudentDetailsByCourse(course);
	}




}
