package com.ms.jwt.security.entity;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//Entiteti za token
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

	private String token;
	public JwtAuthenticationToken(String token) {
		super(null, null);
		this.token = token;
		// TODO Auto-generated constructor stub
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public Object getCredentials() {
		return null;
	}
	@Override
	public Object getPrincipal() {
		return null;
	}

}
