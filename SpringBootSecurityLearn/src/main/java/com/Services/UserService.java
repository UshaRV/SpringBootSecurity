package com.Services;

import java.util.HashSet;
import java.util.Set;

import com.Models.User;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	Set<User> set = new HashSet<>();

	public UserService() {

		set.add(new User("usha", "abcd", "ABC@gmail.com"));
		set.add(new User("Rani", "efgh", "EFG@gmail.com"));
	}

	// get all users
	public Set<User> getAllUsers() {

		return this.set;
	}

	// get single user
	public User getUser(String Username) {
		return this.set.stream().filter((user) -> user.getUsername().equals(Username)).findAny().orElse(null);
	}

	// add User
	public User addUser(User user) {

		this.set.add(user);
		return user;
	}

}
