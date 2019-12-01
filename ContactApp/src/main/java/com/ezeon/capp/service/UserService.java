package com.ezeon.capp.service;

import java.util.List;

import com.ezeon.capp.domain.User;
import com.ezeon.capp.exception.UserBlockedException;

public interface UserService {
	
	public static final Integer LOGIN_STATUS_ACTIVE=1;
	public static final Integer LOGIN_STATUS_BLOCKED=2;

	public static final Integer ROLE_ADMIN=1;
	public static final Integer ROLE_USER=2;

	public void register(User user);
	
	/*
	 * The method handles login operation(Authentication) using given credentials,
	 * it returns User object when success and NULL when failed
	 * @throws UserBlockedException when the User account is blocked
	 */
	public User login(String loginName,String password) throws UserBlockedException;
	
	/*
	 * Call this method to get the list of registered users
	 */
	public List<User> getUserList();

	/*
	 * This method change the User login status 
	 */
	public void changeLoginStatus(Integer userId,Integer loginStatus);
	
}
