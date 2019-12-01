package com.ezeon.capp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezeon.capp.domain.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{

	void save(Optional<Contact> contactFromDb);
	
	public List<Contact> findByUserId(Integer userId);

}
