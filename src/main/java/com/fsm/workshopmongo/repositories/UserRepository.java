package com.fsm.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fsm.workshopmongo.entities.User;

public interface UserRepository extends MongoRepository<User, String> {

}
