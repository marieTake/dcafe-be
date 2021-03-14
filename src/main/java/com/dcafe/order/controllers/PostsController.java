package com.dcafe.order.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dcafe.order.entities.Posts;
import com.dcafe.order.repos.PostsRepository;

@RestController
@RequestMapping("/posts")
public class PostsController {
	
	private PostsRepository repository;
	
	@Autowired
	PostsController(PostsRepository repository){
		this.repository = repository;
	}
	
	@RequestMapping(value="/getposts", method=RequestMethod.GET)
	public List<Posts> getPosts(){
		return repository.findAll();
	}
	
	@RequestMapping(value="/getpost/{id}")
	public Posts getPost(@PathVariable("id") int id) {
		return repository.findById(id).get();
	}
	
	@RequestMapping(value="/saveposts", method=RequestMethod.POST)
	public Posts savePosts(@RequestBody Posts posts) {
		return repository.save(posts);
	}

}
