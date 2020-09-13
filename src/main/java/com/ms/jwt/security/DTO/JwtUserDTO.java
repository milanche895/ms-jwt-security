package com.ms.jwt.security.DTO;
// parametri za User-a
public class JwtUserDTO {

	private String userName;
	
	private String password;
	
	private String roleName;
	
	public JwtUserDTO() {
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
