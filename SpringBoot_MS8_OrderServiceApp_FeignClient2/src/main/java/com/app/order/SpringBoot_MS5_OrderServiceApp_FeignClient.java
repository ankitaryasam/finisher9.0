package com.app.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class SpringBoot_MS5_OrderServiceApp_FeignClient {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot_MS5_OrderServiceApp_FeignClient.class, args);
	}
	
	

}
