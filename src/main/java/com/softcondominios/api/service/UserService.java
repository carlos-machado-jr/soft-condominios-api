package com.softcondominios.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import com.softcondominios.api.domain.UserDomain;
import com.softcondominios.api.repository.UserRepository;
import com.softcondominios.api.security.UserSS;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
	
	public Page<UserDomain> findAll(Pageable page){ 
//		 
        return userRepository.findAll(page);
        
	}
	
	public UserDomain save(UserDomain user) {
		return userRepository.save(user);
	}
}
