package com.zenthree.chatapp.dto;

public class IndividualMessageDto {

	private String fromUserID;
	private String toUserId;
	
	public String getFromUserID() {
		return fromUserID;
	}
	public void setFromUserID(String fromUserID) {
		this.fromUserID = fromUserID;
	}
	public String getToUserId() {
		return toUserId;
	}
	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IndividualMessageDto [fromUserID=");
		builder.append(fromUserID);
		builder.append(", toUserId=");
		builder.append(toUserId);
		builder.append("]");
		return builder.toString();
	}
	

	
}
