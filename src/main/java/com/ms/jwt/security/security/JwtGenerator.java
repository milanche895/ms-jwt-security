package com.ms.jwt.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.jwt.security.entity.JwtUser;
import com.ms.jwt.security.respository.JwtRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {

	@Autowired
	public JwtRepository jwtRepository;
	//Ovde pravimo token
	public String generate(JwtUser jwtUser) {
		// TODO Auto-generated method stub
		Claims claims = Jwts.claims()
				.setSubject(jwtUser.getUserName());
		claims.put("userId", String.valueOf(jwtUser.getId()));
		claims.put("role", jwtUser.getRole().getRoleName());
		
	return	Jwts.builder()
		.setClaims(claims)
		.signWith(SignatureAlgorithm.HS512, "youtube")
		.compact();
		
	}

}
