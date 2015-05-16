package com.yang.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.yang.base.BaseDaoImpl;
import com.yang.entity.User;
import com.yang.service.UserService;

@Service
public class UserServiceImpl extends BaseDaoImpl<User> implements UserService{

	@Override
	public User findUserByName(String userName) {
		String sql = "from User user where user.userName = ?";
		Query query = getSession().createQuery(sql);
		query.setString(0, userName);
		@SuppressWarnings("unchecked")
		List<User> userList = query.list();
		if (userList.size() != 0) {
			System.out.println(userList.get(0).getUserName());
			return userList.get(0);
		}
		return null;
	}

}
