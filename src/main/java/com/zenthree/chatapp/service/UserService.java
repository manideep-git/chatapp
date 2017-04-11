package com.zenthree.chatapp.service;

import java.util.List;

import com.zenthree.chatapp.domain.User;

public interface UserService {

	User createUser(User user);
	
	List<User> getAllUsers();
}
