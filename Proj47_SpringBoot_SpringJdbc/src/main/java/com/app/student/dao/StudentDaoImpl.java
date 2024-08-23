package com.app.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {
	
	//query
	
	private static final String COUNT_STUDENT="SELECT COUNT(*) FROM student_details";
    private static final String GET_STUDENT_NAME="SELECT name from student_details WHERE id=?";
	private static final String GET_STUDENT_DETAILS="SELECT id,name,email,course_name,obtained_marks,grade FROM student_details WHERE id=?";
	private static final String GET_ALL_STUDENT_DETAILS_by_course="SELECT id,name,email,course_name,obtained_marks,grade FROM student_details WHERE course_name=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	
	@Override
	public int getTotalNoOfStudents() throws Exception {
		int totalNoOfStudents = 0;
		totalNoOfStudents = jdbcTemplate.queryForObject(COUNT_STUDENT, Integer.class);
		return totalNoOfStudents;
	}
	
	
	public String getStudentNameById(int id) {
		String studentName = null;
		studentName = jdbcTemplate.queryForObject(GET_STUDENT_NAME, String.class, id);
		return studentName;
	}


	@Override
	public Map<String, Object> getStudentDetailsById(int id) throws Exception {
		Map<String, Object> studentRecord = null;
		studentRecord = jdbcTemplate.queryForMap(GET_STUDENT_DETAILS, id);
		return studentRecord;
	}


	@Override
	public List<Map<String, Object>> getAllStudentDetailsByCourse(String courseName) throws Exception {
		return jdbcTemplate.queryForList(GET_ALL_STUDENT_DETAILS_by_course,courseName);
	}
	
	
	
	
	
      
}
