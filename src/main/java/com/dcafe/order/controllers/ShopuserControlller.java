package com.dcafe.order.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dcafe.order.dto.ShopUserLoginRequest;
import com.dcafe.order.entities.Shopuser;
import com.dcafe.order.repos.ShopUserRepository;

@RestController
@CrossOrigin
@RequestMapping("/shopuser")
public class ShopuserControlller {
	
	private ShopUserRepository shopUserRepository;
	
	@Autowired
	ShopuserControlller(ShopUserRepository shopUserRepository){
		this.shopUserRepository = shopUserRepository;
	}

	@RequestMapping(value="/getshopuser", method=RequestMethod.GET)
	public List<Shopuser> getShopUser(){
		return shopUserRepository.findAll();
	}
	
	@RequestMapping(value="/findshopuser/{id}")
	public Shopuser findShopUser(@PathVariable("id") String id) {
		return shopUserRepository.findByShopAdminId(id);
	}
	
	@RequestMapping(value="/saveshopuser", method=RequestMethod.POST)
	public Shopuser saveShopUser(@RequestBody Shopuser shopuser) {
		return shopUserRepository.save(shopuser);
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public Boolean login(@RequestBody ShopUserLoginRequest loginRequest) {
		Shopuser user = shopUserRepository.findByShopAdminId(loginRequest.getShopAdminId());
		if(user.getPassword().equals(loginRequest.getPassword())){
			return true;
		}else {
			return false;
		}
	}
	
	
}
