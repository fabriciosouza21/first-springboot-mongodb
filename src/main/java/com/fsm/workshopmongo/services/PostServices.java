package com.fsm.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsm.workshopmongo.entities.Post;
import com.fsm.workshopmongo.repositories.PostRepository;
import com.fsm.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostServices {

	@Autowired
	private PostRepository repository;

	public Post findById(String id) {
		Optional<Post> post = repository.findById(id);
		if (post.isEmpty()) {
			throw new ObjectNotFoundException("object not found");
		}
		return post.get();

	}
}
