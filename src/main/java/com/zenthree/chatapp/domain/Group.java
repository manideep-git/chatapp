package com.zenthree.chatapp.domain;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Group {

	@Id
	private String id;
	private String groupName;
	private List<String> userIds;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<String> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<String> userIds) {
		this.userIds = userIds;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Group [id=");
		builder.append(id);
		builder.append(", groupName=");
		builder.append(groupName);
		builder.append(", userIds=");
		builder.append(userIds);
		builder.append("]");
		return builder.toString();
	}

}
