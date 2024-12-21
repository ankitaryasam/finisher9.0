package com.springsecurity.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome dear!";
	}
	
	@GetMapping("hello")
	public String hello() {
		return "Hello User!";
	}
	

}

