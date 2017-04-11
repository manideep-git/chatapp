package com.zenthree.chatapp.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zenthree.chatapp.domain.Group;

public interface GroupRepo extends MongoRepository<Group,String> {

}
