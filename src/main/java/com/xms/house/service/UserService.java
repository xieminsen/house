package com.xms.house.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xms.house.dao.UserMapper;
import com.xms.house.entity.User;
import com.xms.house.util.MapContext;
import com.xms.house.util.PageParam;
import com.xms.house.util.PageUtil;
import com.xms.house.util.PageVo;

@Service
public class UserService {

	@Resource
	private UserMapper userMapper; //注入dao
	/**
	 * 得到userList
	 * @param user
	 * @return
	 */
	public List<User> getUserList(User user){
		MapContext map = MapContext.newOne();
		map.put("user", user);
		return userMapper.selectByFilter(map);
	}
	
	/**
	 * 得到userList分页
	 * @param example
	 * @return
	 */
	public PageVo<User> getUserPage(User user,PageParam pageParam){
		PageUtil.pageParam(pageParam);
		MapContext map = MapContext.newOne();
		map.put("user", user);
		List<User> list=userMapper.selectByFilter(map);
		return PageUtil.getPage(list, pageParam);
	}
}
