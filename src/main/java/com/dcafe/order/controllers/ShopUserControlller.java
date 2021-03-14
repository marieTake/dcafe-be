package com.dcafe.order.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dcafe.order.entities.ShopUser;
import com.dcafe.order.repos.ShopUserRepository;

@RestController
@RequestMapping("/shopuser")
public class ShopUserControlller {
	
	private ShopUserRepository shopUserRepository;
	
	@Autowired
	ShopUserControlller(ShopUserRepository shopUserRepository){
		this.shopUserRepository = shopUserRepository;
	}

	@RequestMapping(value="/getshopuser", method=RequestMethod.GET)
	public List<ShopUser> getShopUser(){
		return shopUserRepository.findAll();
	}
	
	@RequestMapping(value="/findshopuser/{id}")
	public ShopUser findShopUser(@PathVariable("id") String id) {
		return shopUserRepository.findByShopAdminId(id);
	}
	
	@RequestMapping(value="/saveshopuser", method=RequestMethod.POST)
	public ShopUser saveShopAdmin(@RequestBody ShopUser shopuser) {
		return shopUserRepository.save(shopuser);
	}
}
