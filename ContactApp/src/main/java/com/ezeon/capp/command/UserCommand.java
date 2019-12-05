package com.ezeon.capp.command;

import com.ezeon.capp.domain.User;

public class UserCommand {

	@Override
	public String toString() {
		return "UserCommand [user=" + user + "]";
	}

	User user;
	//TODO: Add more fields if required

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
