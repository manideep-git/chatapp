package com.zenthree.chatapp.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zenthree.chatapp.domain.Message;

public interface MessageRepo extends MongoRepository<Message, String> {

	List<Message> findByChatGroupId(String chatGroupId);
	
	List<Message> findByFromUserAndToUser(String fromUser,String toUser);
}
