package com.ms.jwt.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.jwt.security.entity.JwtUser;
import com.ms.jwt.security.respository.JwtRepository;
import com.ms.jwt.security.security.JwtGenerator;

@Service
public class JwtUserService {
		
	@Autowired
	public JwtRepository jwtRepository;
	
	@Autowired
	public JwtGenerator jwtGenerator;
	
	public String loginUser(JwtUser jwtUser) {
	
		JwtUser user = jwtRepository.findOneByUserName(jwtUser.getUserName());
		
	if(user == null) {
		return "";
	
	}else {
		
		
		if(user.getPassword().equals(jwtUser.getPassword())) {
			
		return jwtGenerator.generate(user);		
		
			}else {
			
				return "";	
		}
		

		}
		
	}
}
