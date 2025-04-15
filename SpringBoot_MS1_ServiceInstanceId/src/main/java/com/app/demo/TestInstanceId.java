package com.app.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestInstanceId implements CommandLineRunner{

	@Value("${spring.application.name}")
	private String appName;
	
	@Value("${app.instance.id}")
	private String instanceId;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(appName);
		
		System.out.println(instanceId);
		
	}

}
