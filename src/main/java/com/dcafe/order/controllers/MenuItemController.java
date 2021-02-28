package com.dcafe.order.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dcafe.order.entities.MenuItem;
import com.dcafe.order.repos.MenuItemRepository;

@RestController
@RequestMapping("/menuitem")
public class MenuItemController {
	
	private MenuItemRepository repository;
	
	@Autowired
	MenuItemController(MenuItemRepository repository){
		this.repository = repository;
	}
	
	@RequestMapping(value="/getmenuitems", method=RequestMethod.GET)
	public List<MenuItem> getMenuItems(){
		return repository.findAll();
	}
	
	@RequestMapping(value="/getmenuitem/{id}")
	public MenuItem getMenuItem(@PathVariable("id") int id) {
		return repository.findById(id).get();
	}
	
	@RequestMapping(value="/savemenuitem", method=RequestMethod.POST)
	public MenuItem saveMenuItem(@RequestBody MenuItem menuItem) {
		return repository.save(menuItem);
	}
	

}
