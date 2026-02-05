package com.codegnan.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.codegnan.model.User;
import com.codegnan.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	private UserService userService;

	private static final Logger log=LoggerFactory.getLogger(UserController.class);
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)// 201
	public User createUser(@RequestBody User user) {
		log.info("UserController:: createUser{}",user.getUserId());
		return userService.addUser(user);
	}
	
	@GetMapping("/{userId}")
	public User fetchUser(@PathVariable Integer userId) {
		log.info("UserController:: fetchUser for{} ", userId);
		return userService.findByUserId(userId);
	}
	
	@GetMapping
	public List<User> findAllUsers() {
		log.info("UserController:: fetch all users");
		return userService.findAllUsers();
	}
	
	@PutMapping("/{userId}")
	public User update(@PathVariable Integer userId, @RequestBody User user) {
		log.info("UserController:: update User ", user.getUserId());
		return userService.updateUser(userId, user);
	}
	
	@DeleteMapping("/{userId}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)// 204
	public void delete(@PathVariable Integer userId) {
		log.info("UserController:: delete for{} ", userId);
		userService.deleteUser(userId);
	}
}
