package com.student.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.student.entity.StudentEntity;

@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {
	
	//sql query with named params
	private static final String GET_STUDENT_NAME="SELECT name FROM student_details WHERE id=:id";
	private static final String GET_STUDENTS_BY_COURSE="SELECT * FROM student_details WHERE course_name IN(:course1, :course2, :course3)";
	private static final String INSERT_STUDENT = "INSERT INTO student_details(id,name,email,course_name,obtained_marks,grade) values(:id, :name, :email, :course_name, :obtained_marks, :grade)";                                                  
	
	@Autowired
	@Qualifier("npmjt")
	private NamedParameterJdbcTemplate npmjt;
	

	@Override
	public String getStudentName(int id) throws Exception {
		
		/*
		   Map<String, Object> mapParam = new HashMap<String, Object>();
		   mapParam.put("id", id);
		 */
		
		//java 9 features
		Map<String, Object>  paramMap = Map.of("id", id);
		
		String studentName = npmjt.queryForObject(
										GET_STUDENT_NAME, 
										paramMap, 
										String.class
										);
		
		return studentName;
	}


	@Override
	public List<StudentEntity> getStudentDetailsByCourse(String course1, String course2, String course3)
			throws Exception {
		List<StudentEntity> studentEntityList=null;
		
		MapSqlParameterSource psps = new MapSqlParameterSource();
		psps.addValue("course1", course1);
		psps.addValue("course2", course2);
		psps.addValue("course3", course3);
		
		studentEntityList = npmjt.query(
				GET_STUDENTS_BY_COURSE,
				psps,
				rs -> {
					List<StudentEntity> studentList = new ArrayList<StudentEntity>();
					while(rs.next()) {
						StudentEntity entity = new StudentEntity();
						entity.setId(rs.getInt(1));
						entity.setName(rs.getString(2));
						entity.setEmail(rs.getString(3));
						entity.setCourse_name(rs.getString(4));
						entity.setObtained_marks(rs.getInt(5));
						entity.setGrade(rs.getString(6));
						studentList.add(entity);
					}
					return studentList;
				});
		
		return studentEntityList;
	}


	@Override
	public int registerStudent(StudentEntity entity) throws Exception {
		//create
		BeanPropertySqlParameterSource bpsps = new BeanPropertySqlParameterSource(entity);
		int count = npmjt.update(INSERT_STUDENT, bpsps);
		return count;
	}
	
	
		
}








