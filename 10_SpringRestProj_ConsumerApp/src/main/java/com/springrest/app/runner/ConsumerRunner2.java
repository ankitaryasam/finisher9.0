package com.springrest.app.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConsumerRunner2 implements CommandLineRunner {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${provider.base.url}")
	private String baseUrl;

	
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerRunner2.class);

	@Override
	public void run(String... args) throws Exception {
		
		
		String uri = new StringBuffer()
								.append(baseUrl)
									.append("/test")
									.toString();
		
		
			ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		
	
			
			
			LOGGER.info("Status Code :: {}", response.getStatusCode().value());
			LOGGER.info("Data is {} ", response.getBody());
		
	}

}
