package com.fsm.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fsm.workshopmongo.entities.Post;
import com.fsm.workshopmongo.resources.util.URL;
import com.fsm.workshopmongo.services.PostServices;

@RestController
@RequestMapping(value = "/posts")
public class PostResources {
	
	@Autowired 
	private PostServices service;
	

	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		
		Post post = service.findById(id);
		
		return ResponseEntity.ok().body(post);
	}
	
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text",defaultValue = "") String  text){
		text = URL.decodeparam(text);
		List<Post> posts = service.findByTitle(text);	
		
		return ResponseEntity.ok().body(posts);
	}
	
	

}
