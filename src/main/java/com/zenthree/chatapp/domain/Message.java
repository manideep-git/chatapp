package com.zenthree.chatapp.domain;

import org.springframework.data.annotation.Id;

import com.zenthree.chatapp.enums.MessageType;

public class Message {

	@Id
	private String id;
	private String message;
	private String fromUser;
	private String toUser;
	private MessageType messageType;
	private String chatGroupId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getFromUser() {
		return fromUser;
	}
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
	public String getToUser() {
		return toUser;
	}
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	public MessageType getMessageType() {
		return messageType;
	}
	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}
	public String getChatGroupId() {
		return chatGroupId;
	}
	public void setChatGroupId(String chatGroupId) {
		this.chatGroupId = chatGroupId;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Message [id=");
		builder.append(id);
		builder.append(", message=");
		builder.append(message);
		builder.append(", fromUser=");
		builder.append(fromUser);
		builder.append(", toUser=");
		builder.append(toUser);
		builder.append(", messageType=");
		builder.append(messageType);
		builder.append(", chatGroupId=");
		builder.append(chatGroupId);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
}
