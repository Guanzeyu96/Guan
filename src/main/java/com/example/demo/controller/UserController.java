package com.example.demo.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;

@RestController  
@RequestMapping("/user")
@Api("userController相关api")  
public class UserController {  
        @Autowired  
        private UserService userService;  
          
        @ApiOperation("添加用户")  
        @ApiImplicitParams({  
            @ApiImplicitParam(paramType="query",name="loginname",dataType="String",required=true,value="用户的姓名",defaultValue="zhouzhigang"),  
            @ApiImplicitParam(paramType="query",name="password",dataType="String",required=true,value="用户的密码",defaultValue="123456")  
        })  
        @ApiResponses({  
            @ApiResponse(code=400,message="请求参数没填好"),  
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")  
        })  
        @RequestMapping(value="/addUser",method=RequestMethod.GET)  
        public boolean addUser(@RequestParam("loginname") String loginname,   
                               @RequestParam("password") String password) {  
            return userService.addUser(loginname,password);  
        }  
          
        @ApiOperation("添加用户且返回已经设置了主键的user实例")  
        @ApiImplicitParams({  
            @ApiImplicitParam(paramType="query",name="loginname",dataType="String",required=true,value="用户的姓名",defaultValue="zhouzhigang"),  
            @ApiImplicitParam(paramType="query",name="password",dataType="String",required=true,value="用户的密码",defaultValue="123456")  
        })  
        @ApiResponses({  
            @ApiResponse(code=400,message="请求参数没填好"),  
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")  
        })  
        @RequestMapping(value="/addUserWithBackId",method=RequestMethod.GET)  
        public User addUserWithBackId(@RequestParam("loginname") String loginname,   
                                         @RequestParam("password") String password) {  
            return userService.addUserWithBackId(loginname, password);  
        }
        @RequestMapping("getall")
        @ResponseBody
        public List<User> getAll(){
        	System.out.println("3333");
        	return userService.getAll();
        }
        
  
}  
