package com.app.student.testapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.student.controller.StudentMainController;
import com.app.student.vo.StudentVo;

public class StudentMainApplication {
	
	public static void main(String[] args) {
		ApplicationContext context = null;
		StudentMainController controller = null;
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
	    controller = context.getBean("mainController", StudentMainController.class);
	    
	    
	    StudentVo vo = new StudentVo();
	    vo.setId("1015");
	    vo.setName("Prem Mittal");
	    vo.setEmail("mittalprem@gmail.com");
	    vo.setCourseName("spring");
	    vo.setObtMarks("300");
	    
	   try {
		   controller.registerStudentRequest(vo);
	   }
	   catch(Exception e) {
		   System.out.println("something went wrong...");
		   e.printStackTrace();
	   }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	}

}
