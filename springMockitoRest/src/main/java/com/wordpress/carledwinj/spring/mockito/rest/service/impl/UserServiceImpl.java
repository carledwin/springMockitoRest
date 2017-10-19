package com.wordpress.carledwinj.spring.mockito.rest.service.impl;

import com.wordpress.carledwinj.spring.mockito.rest.model.User;
import com.wordpress.carledwinj.spring.mockito.rest.service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public User get(int id) {
		return null;
	}

	@Override
	public boolean save(User user) {
		return false;
	}

	@Override
	public boolean delete(Long id) {
		return false;
	}

	@Override
	public boolean update(User user) {
		return false;
	}

	

}
