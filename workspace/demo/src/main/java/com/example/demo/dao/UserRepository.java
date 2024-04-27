package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.vo.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value="select * from User where UserName=?1",nativeQuery=true)
	User queryUserName(String UserName);
	
	
	@Query(value="select * from User where UserName=?1 and Password=?2",nativeQuery=true)
	User queryUser(String UserName,String Password);
}
