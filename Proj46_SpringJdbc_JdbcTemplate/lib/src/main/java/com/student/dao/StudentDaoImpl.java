package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.student.entity.StudentEntity;

public class StudentDaoImpl implements StudentDao {
	
	//query
	
	private static final String COUNT_STUDENT="SELECT COUNT(*) FROM student_details";

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
      
}
