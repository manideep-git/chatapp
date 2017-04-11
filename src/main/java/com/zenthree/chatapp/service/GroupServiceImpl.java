package com.zenthree.chatapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zenthree.chatapp.domain.Group;
import com.zenthree.chatapp.repo.GroupRepo;

@Service
public class GroupServiceImpl implements GroupService{

	@Autowired
	private GroupRepo groupRepo;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceImpl.class);
	
	@Override
	public Group createGroup(Group group) {
		LOGGER.info("Inserting the following group details to DB:" + group.toString());
		Group groupDetails = groupRepo.insert(group);
		LOGGER.info("Inserted group details:" + groupDetails.toString());
		return groupDetails;
	}

	@Override
	public List<Group> getAllGroups() {
		LOGGER.info("Geting all groups from DB:");
		List<Group> groupsList = groupRepo.findAll();
		LOGGER.info("getting all groups:" + groupsList.toString());
		return groupsList;
	}
	

}
