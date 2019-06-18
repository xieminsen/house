package com.xms.house.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xms.house.entity.User;
import com.xms.house.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 查询list列表
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/user/list")
	public List<User> selectByFilter(User user,HttpServletRequest request){
		return userService.getUserList(user);
		
	} 
	
	
	/*
	 * 分页查询
	 * @RequestMapping(value = "/user/list", method = RequestMethod.POST)
	public PageVo<User> userList(User user,PageParam pageParam, HttpServletRequest request) {
		return userService.getUserPage(user, pageParam);
	}*/
	
	
}
