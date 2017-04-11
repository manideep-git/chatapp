package com.zenthree.chatapp.endpoint;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zenthree.chatapp.domain.Group;
import com.zenthree.chatapp.domain.Message;
import com.zenthree.chatapp.domain.User;
import com.zenthree.chatapp.dto.IndividualMessageDto;
import com.zenthree.chatapp.service.GroupService;
import com.zenthree.chatapp.service.MessageService;
import com.zenthree.chatapp.service.UserService;

@RestController
public class ChatAppEndpoint {

	@Autowired
	private UserService userService;

	@Autowired
	private MessageService messageService;

	@Autowired
	private GroupService groupService;

	private static final Logger LOGGER = LoggerFactory.getLogger(ChatAppEndpoint.class);

	@PostMapping("/users/saveuser")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		LOGGER.info("In user details create user contorller check i/p:" + user.toString());
		User userDetails = userService.createUser(user);
		return new ResponseEntity<User>(userDetails, HttpStatus.OK);

	}

	@GetMapping("/users/getAllUsers")
	public ResponseEntity<?> getAllUser() {
		LOGGER.info("In user details get all user contorller");
		List<User> userList = userService.getAllUsers();
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);

	}

	@PostMapping("/message/savemessage")
	public ResponseEntity<?> saveMessage(@RequestBody Message message) {
		LOGGER.info("In create message contorller check i/p:" + message.toString());
		Message messageDetails = messageService.saveMessage(message);
		return new ResponseEntity<Message>(messageDetails, HttpStatus.OK);
	}

	@PostMapping("/message/savegroupmessage")
	public ResponseEntity<?> saveGroupMessage(@RequestBody Message message) {
		LOGGER.info("In create group message contorller check i/p:" + message.toString());
		Message savedGroupMessage = messageService.saveGroupMessage(message);
		return new ResponseEntity<Message>(savedGroupMessage, HttpStatus.OK);

	}

	@GetMapping("/message/getallmessagesbygroup/{groupId}")
	public ResponseEntity<?> getAllGroupMessagesBasedOnGroup(@PathVariable String groupId) {
		LOGGER.info("In get All GroupMessages Based On Group contorller");
		List<Message> messageList = messageService.getAllGroupMessagesBasedOnGroup(groupId);
		if (messageList.isEmpty()) {
			return new ResponseEntity<List<Message>>(messageList, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Message>>(messageList, HttpStatus.OK);
		}

	}
	
	@PostMapping("/message/getindividualmessages")
	public ResponseEntity<?> getIndividualMessage(@RequestBody IndividualMessageDto dto) {
		LOGGER.info("In getIndividualMessage contorller check i/p:" + dto.toString());
		List<Message> individualMessage = messageService.getAllIndividualMesages(dto);
		if (individualMessage.isEmpty()) {
			return new ResponseEntity<List<Message>>(individualMessage, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Message>>(individualMessage, HttpStatus.OK);
		}

	}
	
	

	@PostMapping("/group/savegroup")
	public ResponseEntity<?> saveGroup(@RequestBody Group group) {
		LOGGER.info("In create group contorller check i/p:" + group.toString());
		Group groupDetails = groupService.createGroup(group);
		return new ResponseEntity<Group>(groupDetails, HttpStatus.OK);

	}

	@GetMapping("/group/getAllGroups")
	public ResponseEntity<?> getAllGroups() {
		LOGGER.info("In  get all groups contorller");
		List<Group> groupList = groupService.getAllGroups();
		return new ResponseEntity<List<Group>>(groupList, HttpStatus.OK);

	}

}
