package com.ezeon.capp.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ezeon.capp.domain.Contact;
import com.ezeon.capp.service.ContactServiceImpl;

@Component
public class TestContact {

	@Autowired
	private ContactServiceImpl contactServiceImpl;

	public void testUpdateContact() {

	}

	public void testDeleteContact() {
		Integer[] contactIds = {1,4};
		contactServiceImpl.delete(contactIds);
	}
	
	public void testSaveContact() {
		Contact contact=new Contact();
		contact.setUserId(10)
				.setName("Achan")
				.setPhone("9447988176")
				.setEmail("sankarankuttyvr@gmail.com")
				.setAddress("Vadassery H")
				.setRemark("Family");
		contactServiceImpl.save(contact);
	}
	
	public void testFindUserContact() {
		List<Contact> contactList = contactServiceImpl.findUserContact(10);
		for(Contact contact:contactList) {
			System.out.println(contact.getName());
		}
	}
	
	public void testFindUserContactByText() {
		List<Contact> contactList = contactServiceImpl.findUserContact(10,"Vadassery");
		for(Contact contact:contactList) {
			System.out.println(contact.getName());
		}
	}

}
