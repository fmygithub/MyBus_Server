package com.yang.service;

import com.yang.base.BaseDao;
import com.yang.entity.User;

public interface UserService extends BaseDao<User>{
	/**
	 * 
	 * @Description: 通过用户名查询实体
	 * @param userName
	 * @return User
	 * @throws
	 * @author: fengmengyang
	 * @date: 2015-5-15
	 */
	public User findUserByName(String userName);
}
