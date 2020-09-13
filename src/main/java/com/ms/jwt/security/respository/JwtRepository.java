package com.ms.jwt.security.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.jwt.security.entity.JwtUser;

@Repository
public interface JwtRepository extends JpaRepository<JwtUser, Long>{
	
	public JwtUser findOneByUserName(String userName);
	
}
