package com.zenthree.chatapp.service;

import java.util.List;

import com.zenthree.chatapp.domain.Message;
import com.zenthree.chatapp.dto.IndividualMessageDto;

public interface MessageService {

	Message saveMessage(Message message);
	
	Message saveGroupMessage(Message message);
	
	List<Message> getAllGroupMessagesBasedOnGroup(String groupId);
	
	List<Message> getAllIndividualMesages(IndividualMessageDto dto);
}
