package com.codegnan.service;

import java.util.List;

import com.codegnan.dto.UserDto;
import com.codegnan.model.User;

public interface UserService {
	public UserDto addUser(UserDto userDto);

	public User findByUserId(Integer userId);

	public User updateUser(Integer userId, User user);

	public List<User> findAllUsers();

	public void deleteUser(Integer userId);
}
