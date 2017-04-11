package com.zenthree.chatapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zenthree.chatapp.domain.Message;
import com.zenthree.chatapp.domain.User;
import com.zenthree.chatapp.dto.IndividualMessageDto;
import com.zenthree.chatapp.exception.GroupMessageValidationException;
import com.zenthree.chatapp.exception.UserNotFoundException;
import com.zenthree.chatapp.repo.MessageRepo;
import com.zenthree.chatapp.repo.UserRepo;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private MessageRepo messageRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceImpl.class);

	@Override
	public Message saveMessage(Message message) {

		List<User> userFromList = userRepo.findById(message.getFromUser());

		List<User> userToList = userRepo.findById(message.getToUser());

		LOGGER.info("********Find by Id**********:" + userFromList.size() + " : " + userFromList.isEmpty());

		if (userFromList.isEmpty() || userToList.isEmpty()) {

			throw new UserNotFoundException("User not found");

		} else {
			LOGGER.info("Inserting the following message details to DB:" + message.toString());
			Message messageDetails = messageRepo.insert(message);
			LOGGER.info("Inserted message details:" + messageDetails.toString());
			return messageDetails;
		}
	}

	@Override
	public Message saveGroupMessage(Message message) {
		List<User> userFromList = userRepo.findById(message.getFromUser());

		if (userFromList.isEmpty()) {
			throw new UserNotFoundException("User not found");

		} else if (message.getChatGroupId() == "" || message.getChatGroupId() == null) {
			LOGGER.info("Group Id is null or empty");
			throw new GroupMessageValidationException("Group Id can't be empty or null for Group message");
		} else {

			LOGGER.info("Inserting the following Groupmessage details to DB:" + message.toString());
			Message messageDetails = messageRepo.insert(message);
			LOGGER.info("Inserted Groupmessage details:" + messageDetails.toString());
			return messageDetails;
		}
	}

	@Override
	public List<Message> getAllGroupMessagesBasedOnGroup(String groupId) {
		LOGGER.info("Getting all messages related to group: " + groupId);
		List<Message> groupMessage = messageRepo.findByChatGroupId(groupId);
		LOGGER.info("Messages related to group are:" + groupMessage.toString());
		return groupMessage;
	}

	@Override
	public List<Message> getAllIndividualMesages(IndividualMessageDto dto) {
		List<Message> individualMessages = messageRepo.findByFromUserAndToUser(dto.getFromUserID(), dto.getToUserId());
		LOGGER.info("Individual Messages related to from and to user:" + individualMessages.toString());
		return individualMessages;
	}

}
