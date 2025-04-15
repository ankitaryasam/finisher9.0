package com.app.eurekademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringBootMs2EurekaServerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMs2EurekaServerDemoApplication.class, args);
	}

}
