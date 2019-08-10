package com.mazdasales.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazdasales.api.dao.UserDao;
import com.mazdasales.api.model.User;

@Service("UserService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.save(user);
	}

}
