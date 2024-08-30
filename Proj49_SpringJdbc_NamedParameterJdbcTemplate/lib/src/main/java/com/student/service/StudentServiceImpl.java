package com.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.student.dao.StudentDao;
import com.student.dto.StudentDto;
import com.student.entity.StudentEntity;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;

	@Override
	public String getStudentName(int id) throws Exception {
		return studentDao.getStudentName(id);
	}

	@Override
	public List<StudentDto> getStudentDetailsByCourse(String course1, String course2, String course3) throws Exception {
		List<StudentEntity> studentEntityList = null;
		List<StudentDto> studentDtoList = null;
		studentDtoList = new ArrayList<StudentDto>();
		
		studentEntityList = studentDao.getStudentDetailsByCourse(course1, course2, course3);
		
		for(StudentEntity entity :  studentEntityList) {
			StudentDto dto = new StudentDto();
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setEmail(entity.getEmail());
			dto.setCourseName(entity.getCourse_name());
			dto.setObtainedMarks(entity.getObtained_marks());
			dto.setGrade(entity.getGrade());
			studentDtoList.add(dto);
		}
		
		return studentDtoList;
	}

	@Override
	public int registerNewStudent(StudentDto dto) throws Exception {
		StudentEntity entity = null;
		entity = new StudentEntity();
		
		String grade = null;
		
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setCourse_name(dto.getCourseName());
		entity.setObtained_marks(dto.getObtainedMarks());
		
		//calculate gradle
				if(dto.getObtainedMarks() >= 400) {
					grade = "A";
				}
				else if(dto.getObtainedMarks() >= 350) {
					grade="B";
				}
				else if(dto.getObtainedMarks() >= 300) {
				    grade="C";
				}
				else if(dto.getObtainedMarks() >= 200) {
					grade="D";
				}
				else {
					grade="Fail";
				}
				
				dto.setGrade(grade);
				entity.setGrade(dto.getGrade());
				
		
		int count = studentDao.registerStudent(entity);
		return count;
	}
	
	
	
	
	
}
