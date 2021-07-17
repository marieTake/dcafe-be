package com.dcafe.order.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dcafe.order.entities.Shopuser;
import com.dcafe.order.repos.ShopuserRepository;

@RestController
@CrossOrigin
@RequestMapping("/shopuser")
public class ShopuserControlller {

	private ShopuserRepository shopUserRepository;

	private PasswordEncoder encoder;

	@Autowired
	ShopuserControlller(ShopuserRepository shopUserRepository, PasswordEncoder encoder) {
		this.shopUserRepository = shopUserRepository;
		this.encoder = encoder;
	}

	@RequestMapping(value = "/getshopuser", method = RequestMethod.GET)
	public List<Shopuser> getShopUser() {
		return shopUserRepository.findAll();
	}

	@RequestMapping(value = "/findshopuser/{id}", method = RequestMethod.GET)
	public Shopuser findShopUser(@PathVariable("id") String id) {
		return shopUserRepository.findByShopUserId(id);
	}

	@RequestMapping(value = "/saveshopuser", method = RequestMethod.POST)
	public Shopuser saveShopUser(@RequestBody Shopuser shopuser) {
		shopuser.setPassword(encoder.encode(shopuser.getPassword()));
		Shopuser savedShopuser = shopUserRepository.save(shopuser);
		return savedShopuser;
	}

	

}
