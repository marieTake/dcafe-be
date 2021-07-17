package com.dcafe.order.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dcafe.order.entities.Shopuser;
import com.dcafe.order.repos.ShopuserRepository;

@Service
public class ShopuserServiceImpl implements ShopuserService {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private ShopuserRepository repository;

	@Override
	public Shopuser findShopuser(String shopuserId, String password) {
		Shopuser user = repository.findByShopUserIdAndPassword(shopuserId, encoder.encode(password));
		return user;
	}

}
