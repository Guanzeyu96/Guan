package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.pojo.User;

public interface UserMapper {
	@Insert("INSERT INTO tb_user(loginname, password) VALUES(#{loginName},#{password})")  
	public int insertUser(@Param("loginName") String loginName, @Param("password")  String password);  

	/**  
	 * 插入用户，并将主键设置到user中  
	 * 注意：返回的是数据库影响条数，即1  
	 */  
	public int insertUserWithBackId(User user);
	
	@Select("select * from tb_user")
	public List<User> getAll();
}
