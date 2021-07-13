package com.fsm.workshopmongo.services;

import java.util.Date;
import java.util.List;
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

	public List<Post> findByTitle(String text) {
		return repository.searchTitle(text);
	}

	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24*60*60*1000);
		return repository.fullSeach(text, minDate, maxDate);
	}
}
