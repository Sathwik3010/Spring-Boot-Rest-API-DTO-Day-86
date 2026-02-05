package com.codegnan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codegnan.model.User;
import com.codegnan.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findByUserId(Integer userId) {
		Optional<User> optional = userRepository.findById(userId);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			throw new RuntimeException("User Not found in DB");
		}
	}

	@Override
	public User updateUser(Integer userId, User user) {
		User dbUser=findByUserId(userId);
		dbUser.setFirstName(user.getFirstName());
		dbUser.setLastName(user.getLastName());
		dbUser.setEmail(user.getEmail());
		dbUser.setPhone(user.getPhone());
		userRepository.save(dbUser);
		return dbUser;
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(Integer userId) {
		User dbUser=findByUserId(userId);
		userRepository.deleteById(userId);
	}
	
	
}
