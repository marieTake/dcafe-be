package com.dcafe.order.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dcafe.order.entities.ShopAdmin;
import com.dcafe.order.repos.ShopAdminRepository;

@RestController
@CrossOrigin
@RequestMapping("/shopadmin")
public class ShopAdminController {
	
	private ShopAdminRepository shopAdminRepository;
	
	@Autowired
	ShopAdminController(ShopAdminRepository shopAdminRepository){
		this.shopAdminRepository = shopAdminRepository;
	}

	@RequestMapping(value="/getshopadmin", method=RequestMethod.GET)
	public List<ShopAdmin> getShopAdmin(){
		return shopAdminRepository.findAll();
	}
	
	@RequestMapping(value="/findshopadmin/{id}")
	public ShopAdmin findShopAdmin(@PathVariable("id") int id) {
		return shopAdminRepository.findById(id).get();
	}
	
	@RequestMapping(value="/saveshopadmin", method=RequestMethod.POST)
	public ShopAdmin saveShopAdmin(@RequestBody ShopAdmin shopadmin) {
		return shopAdminRepository.save(shopadmin);
	}
}
