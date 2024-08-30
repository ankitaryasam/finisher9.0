package com.student.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.student.controller.StudentMainController;
import com.student.dto.StudentDto;
import com.student.entity.StudentEntity;

public class JdbcTemplateCallbackInterfacesTest {
	
	public static void main(String[] args) {
		ApplicationContext context = null;
		
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		StudentMainController controller = context.getBean("controller", StudentMainController.class);
	    
		try {
			String studentName = controller.fetchStudentName(1010);
			System.out.println("Student Name: " + studentName);
			System.out.println("-----------------------");
			
			List<StudentDto> dtoList = controller.fetchStudentDetailsByCourse("java", "c++", "spring");
		    System.out.println(dtoList);
		    System.out.println("--------------saving new student below---------");
		    
		    //create dto
		    StudentDto dto = new StudentDto();
		    dto.setId(1022);
		    dto.setName("Dheeraj Kumar");
		    dto.setEmail("dheeraj@gmail.com");
		    dto.setCourseName("c++");
		    dto.setObtainedMarks(180);
		
		    int rowCount = controller.processNewStudentRegistration(dto);
		    System.out.println(rowCount);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close the ioc container
			((AbstractApplicationContext)context).close();
		}
	
	}

}
