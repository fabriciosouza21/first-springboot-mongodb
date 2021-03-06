package com.fsm.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsm.workshopmongo.dto.UserDTO;
import com.fsm.workshopmongo.entities.User;
import com.fsm.workshopmongo.repositories.UserRepository;
import com.fsm.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id){
		Optional<User> user = repository.findById(id);
		if(user.isEmpty()) {
			throw new ObjectNotFoundException("object not found");
		}
		return user.get();		
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User update(User obj) {
		
		User newUser = findById(obj.getId());
		updateData(obj,newUser);
		return repository.save(newUser);		
	}
	
	private void updateData(User obj, User newUser) {
		newUser.setName(obj.getName());
		newUser.setEmail(obj.getEmail());		
	}

	public User fromDTO (UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
}
