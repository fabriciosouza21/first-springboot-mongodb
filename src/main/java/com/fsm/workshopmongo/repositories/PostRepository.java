package com.fsm.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fsm.workshopmongo.entities.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
