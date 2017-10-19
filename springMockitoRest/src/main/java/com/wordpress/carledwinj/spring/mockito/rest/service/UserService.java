package com.wordpress.carledwinj.spring.mockito.rest.service;

import com.wordpress.carledwinj.spring.mockito.rest.model.User;

public interface UserService {

	public User get(int id);

	public boolean save(User user);

	public boolean delete(Long id);

	public boolean update(User user);
}
