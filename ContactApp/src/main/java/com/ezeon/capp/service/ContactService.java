package com.ezeon.capp.service;

import java.util.List;

import com.ezeon.capp.domain.Contact;

/*
 * This interface specifies all business operations for Contact entity
 */
public interface ContactService {

	public void save (Contact contact);
	
	public void update(Contact contact);
	
	public void delete (Integer contactId);
	
	public void delete (Integer[] contactIds);
	
	/*
	 * This method returns all User contact (User who is logged in)
	 */
	public List<Contact> findUserContact(Integer userId);
	
	/*
	 * This method search contact for User based on given free-text-criteria (text)
	 * userId -  User who is logged in
	 * text - free text search criteria
	 */
	public List<Contact> findUserContact(Integer userId,String text);
	
}
