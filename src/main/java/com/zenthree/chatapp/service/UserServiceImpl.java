package com.zenthree.chatapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zenthree.chatapp.domain.User;
import com.zenthree.chatapp.exception.UserExistsException;
import com.zenthree.chatapp.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User createUser(User user) {

		List<User> userList = userRepo.findByEmail(user.getEmail());

		LOGGER.info("********Find by email**********:" + userList.size() + " : " + userList.isEmpty());

		if (userList.isEmpty()) {

			LOGGER.info("Inserting the following user details to DB:" + user.toString());
			User insertedDetails = userRepo.insert(user);
			LOGGER.info("Inserted user details:" + insertedDetails.toString());
			return insertedDetails;
		} else {

			throw new UserExistsException("User already exists");
		}

	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

}
