package com.softcondominios.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.UserDomain;
import com.softcondominios.api.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<UserDomain> findAll(){ 
		return userRepository.findAll();
	}
	
	public UserDomain save(UserDomain user) {
		return userRepository.save(user);
	}
}
