package com.ms.jwt.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.jwt.security.DTO.JwtUserDTO;
import com.ms.jwt.security.entity.JwtUser;
import com.ms.jwt.security.respository.JwtRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@RestController
@RequestMapping("/rest/hello")
public class HelloController {
	
	@Autowired JwtRepository jwtRepository;
	//Kreiranje API za hello
	
	@GetMapping
	public String hello() {
		
	return "Hello World";
	
	}
	
	//Kreiranje API za hello/users 
	@GetMapping("/users")
	
	public List<JwtUserDTO> getAllUsers(@RequestHeader("Authorisation") String token) {
		
		String tokenTrim = token.substring(6);
		
		Claims claims =
		(Claims) Jwts.parser()
	    
		  .setSigningKey("youtube") // <----
		  
		  .parseClaimsJws(tokenTrim).getBody();
		
		claims.get("role");
		
		System.out.println(claims.get("role"));
		
		//if
		
		// Pocetno slovo objekta malo
		List<JwtUser> jwtUserList = jwtRepository.findAll();
		
		List<JwtUserDTO> jwtUserDtoList = new ArrayList<JwtUserDTO>();
		// for petlja za prolazak kroz listu
		for (JwtUser jwtUser : jwtUserList) {
			
			JwtUserDTO jwtUserDto = new JwtUserDTO();
			//Dodavanje user i role u objektu
			jwtUserDto.setUserName(jwtUser.getUserName());
			jwtUserDto.setRoleName(jwtUser.getRole().getRoleName());
			//dodeljujemo listi objekat
			jwtUserDtoList.add(jwtUserDto);
			
			
		}
		
		return jwtUserDtoList;
		
	}
}
