package com.springsecurity.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.springsecurity.app.entity.UserEntity;
import com.springsecurity.app.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<UserEntity> userEntity = userRepository.findByEmail(email);
		UserEntity entity = userEntity.get();
		if(!userEntity.isEmpty()) {
			return new UserEntityDetails(entity);
		}
		else {
			throw new UsernameNotFoundException("User not found");
		}
	}
	
	
	public String createUser(UserEntity entity) {
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		userRepository.save(entity);
		return "User saved successfully";
	}
	
	
	
	
	
	
	
	
	
	
  
}
