package com.springsecurity.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecurity.app.entity.UserEntity;
import com.springsecurity.app.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String mobileNumber) throws UsernameNotFoundException {
		//fetch the user from database by mobile number
		
		UserEntity userEntity = userRepo.findByMobileNumber(mobileNumber);
		if(userEntity==null) {
			throw new UsernameNotFoundException("user with given mobile no.- " + mobileNumber + " is not found" );
		}
		else {
			return new User(userEntity.getUsername(), userEntity.getOtp(), true, true, true, true, null);
		}
		
	}

}
