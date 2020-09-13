package com.ms.jwt.security.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Entiteti za user-a
@Entity
//Ime tabele u bazi
@Table(name= "users")
public class JwtUser {
	
	@Id
	private long id;
	
	//Ime kolene u bazi
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="role_id")
	private Role role;
	
	public void setUserName(String userName) {
		this.userName = userName;
		
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public void setId(long id) {
		this.id = id;
		
	}

	public void setRole(Role role) {
		this.role = role;
		
	}

	public String getUserName() {
		return userName;
	}

	public long getId() {
		return id;
	}

	public Role getRole() {
		return role;
	}
	@Override
	public String toString() {
		return "JWtUser [id=" + id + ", firstName=" + userName + ", lastName=" + id + ", emailId=" + role
				+ "]";
	}
	

}

