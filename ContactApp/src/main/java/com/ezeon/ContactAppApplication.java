package com.ezeon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ezeon.capp.test.TestContact;
import com.ezeon.capp.test.TestUser;


@SpringBootApplication
public class ContactAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactAppApplication.class, args);
	}
}

/*
@SpringBootApplication
public class ContactAppApplication implements CommandLineRunner{
	
	@Autowired
	TestUser testUser;
	
	@Autowired
	TestContact testContact;
	
	public static void main(String[] args) {
		SpringApplication.run(ContactAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("INSIDE MAIN");
		// TODO Auto-generated method stub
		//testUser.testRegisterUser();
		//testContact.testDeleteContact();
		//testContact.testFindUserContact();
		//testContact.testSaveContact();
		testContact.testFindUserContactByText();
	}
}
*/
