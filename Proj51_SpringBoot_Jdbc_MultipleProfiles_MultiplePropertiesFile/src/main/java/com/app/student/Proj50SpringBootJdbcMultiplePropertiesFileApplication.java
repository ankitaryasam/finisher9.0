package com.app.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.app.student.controller.StudentMainController;
import com.app.student.dto.StudentDto;

@SpringBootApplication
public class Proj50SpringBootJdbcMultiplePropertiesFileApplication {

	public static void main(String[] args) {
	    ApplicationContext context = null;
		StudentMainController controller = null;
	context = SpringApplication.run(Proj50SpringBootJdbcMultiplePropertiesFileApplication.class, args);
	
	controller =  context.getBean("controller", StudentMainController.class);
	
	StudentDto dto = new StudentDto();
	dto.setId(1027);
	dto.setName("Krishna Verma");
	dto.setEmail("krishna@gmail.com");
	dto.setCourseName("spring boot");
	dto.setObtainedMarks(360);
	
	
	try {
		int i = controller.processNewStudentRegistration(dto);
		System.out.println(i);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	finally {
		((ConfigurableApplicationContext)context).close();
	}
	
	}

}
