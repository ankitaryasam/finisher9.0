package com.springrest.app.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


public class ConsumerRunner implements CommandLineRunner {
	
	@Autowired
	private RestTemplate restTemplate;
	

	
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerRunner.class);

	@Override
	public void run(String... args) throws Exception {
		
		//TODO :  1. Create the RestTemplate object
		
//		RestTemplate restTemplate = new RestTemplate();
		
		//  2.  define the url path that you want to call
		
		String url = "http://localhost:8080/test";
		
		//  3. Make the http call using RestTemplate object and get the response
		
			ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		
		//  4.  use the reponse further in the consumer app
			
			
			LOGGER.info("Status Code :: {}", response.getStatusCode().value());
			LOGGER.info("Data is {} ", response.getBody());
				
			
			
			//rest api --backend(springboot)  --->  provider app
			
			
			// spring mvc(ui)--->  ModelAndView(studentEntity)
			// restTemplate::   response:: StudentEntity ka object ..studentEntity
		
	}

}
