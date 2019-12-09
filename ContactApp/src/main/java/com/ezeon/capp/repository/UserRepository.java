package com.ezeon.capp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezeon.capp.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public List<User> findByRole(Integer role);

}
