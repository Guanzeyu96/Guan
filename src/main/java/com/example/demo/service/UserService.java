package com.example.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;

@Service
public class UserService {
	
	@Resource
	private UserMapper mapper;
	
	
	public UserMapper getMapper() {
		return mapper;
	}

	public void setMapper(UserMapper mapper) {
		this.mapper = mapper;
	}

	public boolean addUser(String username, String password){  
		return mapper.insertUser(username, password)==1?true:false;  
	}  

	public User addUserWithBackId(String loginname, String password){  
		User user = new User();  
		user.setLoginName(loginname);  
		user.setPassword(password);  
		mapper.insertUserWithBackId(user);//该方法后，主键已经设置到user中了  
		return user;  
	} 
	
	public List<User> getAll(){
		return mapper.getAll();
	}
}
