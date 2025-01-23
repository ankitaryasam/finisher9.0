package com.springrest.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springrest.app.entity.StudentEntity;

public class ObjectMapperTest {
	
	public static void main(String[] args) {
	/*	try {
			//StudentEntity data ----> JSON
			
			StudentEntity entity = new StudentEntity();
			entity.setId(101);
			entity.setName("Manish Kumar Pal");
			entity.setCourse("springboot");
			
			//use jackson api ObjectMapper class
			
			ObjectMapper om = new ObjectMapper();
			 String jsonData = om.writeValueAsString(entity);
			 System.out.println(jsonData);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		*/
		
		try {
			String jsonData = "{\"id\":101,\"name\":\"Manish Kumar Pal\",\"course\":\"springboot\"}";
			
			ObjectMapper om = new ObjectMapper();
			StudentEntity entity = om.readValue(jsonData, StudentEntity.class);
			System.out.println(entity);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
