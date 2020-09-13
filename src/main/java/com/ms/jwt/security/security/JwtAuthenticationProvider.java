package com.ms.jwt.security.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.ms.jwt.security.DTO.JwtUserDetailsDTO;
import com.ms.jwt.security.entity.JwtAuthenticationToken;
import com.ms.jwt.security.entity.JwtUser;
import com.ms.jwt.security.respository.JwtRepository;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider{

	@Autowired
	private JwtValidator validator;
	
	@Autowired
	public JwtRepository jwtRepository;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
		
		JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) usernamePasswordAuthenticationToken;
		
		String token = jwtAuthenticationToken.getToken();
		
		JwtUser jwtUser = validator.validate(token);	
		
		if(jwtUser == null) {
			throw new RuntimeException("JWT Token is incorrect");
		}
		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		
		return new JwtUserDetailsDTO(jwtUser.getUserName(), jwtUser.getId(), token, grantedAuthorities);

	}
	
	@Override
	public boolean supports(Class<?> aClass) {
		return (JwtAuthenticationToken.class.isAssignableFrom(aClass));
	}

}
