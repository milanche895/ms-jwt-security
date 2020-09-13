package com.ms.jwt.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.jwt.security.entity.JwtUser;
import com.ms.jwt.security.security.JwtGenerator;
import com.ms.jwt.security.service.JwtUserService;

@RestController
@RequestMapping("/user")
public class TokenController {
	
	@Autowired
	
	private JwtUserService jwtUserService;
	
	private JwtGenerator jwtGenerator;
	
	public TokenController(JwtGenerator jwtGenerator) {
		this.jwtGenerator = jwtGenerator;
	}
	//Api za proveru tokena
	@PostMapping("/login")
	public String generate(@RequestBody JwtUser jwtUser) {

		return jwtUserService.loginUser(jwtUser);
	}
	
	
}
