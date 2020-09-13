package com.ms.jwt.security.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	
	@Id
	private Integer id;
	
	@Column(name = "role_name")
	private String roleName;
	
	@OneToMany(mappedBy = "role")
	private List<JwtUser> jwtUser;
	
	
	public Role() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<JwtUser> getJwtUser() {
		return jwtUser;
	}

	public void setJwtUser(List<JwtUser> jwtUser) {
		this.jwtUser = jwtUser;
	}
	
	

}
