package com.ms.jwt.security.DTO;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUserDetailsDTO implements UserDetails{
	
	private String userName;
	private String token;
	private Long id;
	private Collection<? extends GrantedAuthority> authorities;
	
	public JwtUserDetailsDTO(String userName, long id, String token, List<GrantedAuthority> grantedAuthorities) {
		
		this.userName = userName;
		this.id = id;
		this.token = token;
		this.authorities = grantedAuthorities;
	}

	@Override 
	public Collection<? extends GrantedAuthority> getAuthorities(){
		return authorities;
	}
	
	@Override
	public String getPassword() {
		return null;
	}
	
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getUserName() {
		return userName;
	}

	public String getToken() {
		return token;
	}


	public Long getId() {
		return id;
	}
	
}
