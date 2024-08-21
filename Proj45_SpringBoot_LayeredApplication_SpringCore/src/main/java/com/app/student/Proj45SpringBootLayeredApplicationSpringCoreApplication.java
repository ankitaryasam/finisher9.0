package com.app.student;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.app.student.controller.StudentMainController;
import com.app.student.vo.StudentVo;
import com.zaxxer.hikari.HikariDataSource;

@SpringBootApplication
public class Proj45SpringBootLayeredApplicationSpringCoreApplication {
	


	public static void main(String[] args) {
		ApplicationContext context = null; 
		context = SpringApplication.run(Proj45SpringBootLayeredApplicationSpringCoreApplication.class, args);
	
	    StudentMainController controller = context.getBean("controller", StudentMainController.class);
	
	    
	    StudentVo vo = new StudentVo();
	    vo.setId("1019");
	    vo.setName("Raj Kumar Patel");
	    vo.setCourseName("java");
	    vo.setEmail("rkpat@gmail.com");
	    vo.setObtMarks("360");
	    
	    try {
	    	controller.registerStudentRequest(vo);
	    }
	    catch(Exception e ) {
	    	e.printStackTrace();
	    }
	    finally {
	    	((ConfigurableApplicationContext)context).close();
	    }
	 }

}
