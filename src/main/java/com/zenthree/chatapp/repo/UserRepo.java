package com.zenthree.chatapp.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zenthree.chatapp.domain.User;

public interface UserRepo extends MongoRepository<User, String> {

	public List<User> findByEmail(String email);
	
	public List<User> findById(String id);

}
