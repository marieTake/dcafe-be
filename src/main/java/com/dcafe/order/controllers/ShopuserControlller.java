package com.dcafe.order.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dcafe.order.dto.ShopUserLoginRequestDTO;
import com.dcafe.order.entities.Shopuser;
import com.dcafe.order.repos.ShopuserRepository;
import com.dcafe.order.services.SecurityService;

@RestController
@CrossOrigin
@RequestMapping("/shopuser")
public class ShopuserControlller {
	
	private ShopuserRepository shopUserRepository;
	
	private BCryptPasswordEncoder encoder;
	
	private SecurityService securityService;
	
	@Autowired
	ShopuserControlller(ShopuserRepository shopUserRepository, BCryptPasswordEncoder encoder, SecurityService securityService){
		this.shopUserRepository = shopUserRepository;
		this.encoder = encoder;
		this.securityService = securityService;
	}

	@RequestMapping(value="/getshopuser", method=RequestMethod.GET)
	public List<Shopuser> getShopUser(){
		return shopUserRepository.findAll();
	}
	
	@RequestMapping(value="/findshopuser/{id}", method=RequestMethod.GET)
	public Shopuser findShopUser(@PathVariable("id") String id) {
		return shopUserRepository.findByShopUserId(id);
	}
	
	@RequestMapping(value="/saveshopuser", method=RequestMethod.POST)
	public Shopuser saveShopUser(@RequestBody Shopuser shopuser) {
		shopuser.setPassword(encoder.encode(shopuser.getPassword()));
		Shopuser savedShopuser = shopUserRepository.save(shopuser);
		return savedShopuser;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public Shopuser login(@RequestBody ShopUserLoginRequestDTO loginRequest) {
		boolean loginResponse = securityService.login(loginRequest.getShopUserId(), loginRequest.getPassword());
		if(loginResponse) {
			return shopUserRepository.findByShopUserId(loginRequest.getShopUserId());
		}else {
			return null;
		}
	}
	
	
}
