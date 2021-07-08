package com.fsm.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsm.workshopmongo.entities.User;
import com.fsm.workshopmongo.repositories.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
}
