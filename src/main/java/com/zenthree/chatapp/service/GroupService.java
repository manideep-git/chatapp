package com.zenthree.chatapp.service;

import java.util.List;

import com.zenthree.chatapp.domain.Group;

public interface GroupService {
	
	Group createGroup(Group group);
	List<Group> getAllGroups();

}
