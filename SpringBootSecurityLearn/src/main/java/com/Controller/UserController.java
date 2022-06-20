package com.Controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

import com.Models.User;
import com.Services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userservice;

	// all users
	 
	@GetMapping("/")
	public Set<User> getAllUsers() {

		return userservice.getAllUsers();
	}

	// return single user

	@GetMapping("/{username}")
//	@PreAuthorize("hasRole('ADMIN')")
	public User getUser(@PathVariable("username") String username) {
		return userservice.getUser(username);
	}

	@PostMapping("/")
	public User add(@RequestBody User user) {
		return this.userservice.addUser(user);
		
	}
	
	}


