package com.ms.jwt.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Client")
public class JwtClient {
	
	@Id
	private Long id;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "companyName")
	private String companyName;

	
	public JwtClient() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
	
}
