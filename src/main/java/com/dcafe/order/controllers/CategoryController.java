package com.dcafe.order.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dcafe.order.entities.Category;
import com.dcafe.order.repos.CategoryRepository;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	private CategoryRepository repository;
	
	@Autowired
	CategoryController(CategoryRepository repository){
		this.repository = repository;
	}
	
	@RequestMapping(value="/getcategories", method=RequestMethod.GET)
	public List<Category> getCategory(){
		return repository.findAll();
	}
	
	@RequestMapping(value="/getcategory/{id}")
	public Category getCategory(@PathVariable("id") int id) {
		return repository.findById(id).get();
	}
	
	@RequestMapping(value="/savecategory", method=RequestMethod.POST)
	public Category saveCategory(@RequestBody Category category) {
		return repository.save(category);
	}

}
