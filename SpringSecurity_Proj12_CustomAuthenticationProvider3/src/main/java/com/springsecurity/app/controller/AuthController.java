package com.springsecurity.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springsecurity.app.config.OtpAuthenticationProvider;
import com.springsecurity.app.repository.UserRepository;

@Controller
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private OtpAuthenticationProvider authProvider;

	@PostMapping("/generate-otp")
	public String generateOtp(@RequestParam String mobileNumber) {
		//validate the user exists by mobile number or not
		
		if(!userRepository.existsById(mobileNumber)) {
			return "User is not registered with the given mobile number";
		}
		
		//generate the otp
		authProvider.generateOtp(mobileNumber);
		
		return "OTP sent/generated to mobile number";
		
	}
	
	@PostMapping("/login")
	public String authenticateUser(@RequestParam String mobileNumber, @RequestParam String otp) {
		try {
			Authentication authenticatedToken = 
					new UsernamePasswordAuthenticationToken(mobileNumber, otp);
			
			//fully populated authentication object
			Authentication authentication = authManager.authenticate(authenticatedToken);
			
			//store the fully populated authentication object in security context
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			return "Authentication successfull";
		}
		catch(Exception e) {
			return "Authentication failed: " + e.getMessage();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
