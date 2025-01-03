package com.springsecurity.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.springsecurity.app.entity.UserEntity;
import com.springsecurity.app.repository.UserRepository;

@Component
public class OtpAuthenticationProvider implements AuthenticationProvider {

	
	@Autowired
	private UserRepository userRepo;
	
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		//extract the mobile and password
		
		String mobileNumber = authentication.getName();
		String otp = authentication.getCredentials().toString();
		
		//check if the user exists in the db with given mobile or not
		
		UserEntity userEntity = userRepo.findByMobileNumber(mobileNumber);
		
		if(userEntity == null) {
			throw new BadCredentialsException("Invalid mobile or otp");
		}
		
		//validate the otp
		if(!userEntity.getOtp().equals(otp)) {
			throw new BadCredentialsException("Invalid mobile or otp");
		}
		
		//if everything is valid 
		
		UsernamePasswordAuthenticationToken authenticatedToken = 
				new UsernamePasswordAuthenticationToken(mobileNumber, otp, null);
		
		return authenticatedToken;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	//generate and send otp or save otp
	
	public void generateOtp(String mobileNumber) {
		String generatedOTP =  String.valueOf((int)(Math.random() * 900000 ) + 100000);
		
		//fetch the user by mobile number and save the otp...update user
		
		UserEntity userEntity = userRepo.findByMobileNumber(mobileNumber);
		if(userEntity!=null) {
			userEntity.setOtp(generatedOTP);
			userRepo.save(userEntity);
		}
		
		//some code to send otp to mobile
		
		System.out.println("OTP sent to " + mobileNumber + " OTP : " + generatedOTP);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
