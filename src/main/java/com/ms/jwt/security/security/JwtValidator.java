package com.ms.jwt.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.jwt.security.entity.JwtUser;
import com.ms.jwt.security.respository.JwtRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {

	@Autowired
	
	public JwtRepository jwtRepository;
	
	private String secret = "youtube";
	
	public JwtUser validate(String token) {
		
		JwtUser jwtUser = null;
		try {
		Claims body = Jwts.parser()
				.setSigningKey(secret)
				.parseClaimsJws(token)
				.getBody();
		
		jwtUser = new JwtUser();
		
		jwtUser.setUserName(body.getSubject());
		jwtUser.setId(Long.parseLong((String)body.get("userId")));
//		jwtUser.setRole((String)body.get("role"));
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return jwtUser;
	}

}
