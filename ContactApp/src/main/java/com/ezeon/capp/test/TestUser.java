package com.ezeon.capp.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ezeon.capp.domain.Contact;
import com.ezeon.capp.domain.User;
import com.ezeon.capp.service.UserService;
import com.ezeon.capp.service.UserServiceImpl;

@Component
public class TestUser {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	public void testRegisterUser() {
		User user=new User();
		user.setName("Abhilash")
			.setPhone("9995101430")
			.setEmail("abhi@ust.com")
			.setAddress("UST Kochi")
			.setLoginName("abhi")
			.setPassword("1234")
			.setRole(UserService.ROLE_ADMIN)
			.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
		
		Contact contact = new Contact();
		contact.setName("Amma")
				.setPhone("9496334098")
				.setEmail("pkvsankar@gmail.com")
				.setAddress("Vadassery H")
				.setRemark("Family");
		List<Contact> contactList = new ArrayList<Contact>();
		contactList.add(contact);
		
		user.setContacts(contactList);
		
		userServiceImpl.register(user);
	}

}
