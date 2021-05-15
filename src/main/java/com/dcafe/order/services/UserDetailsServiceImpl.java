package com.dcafe.order.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dcafe.order.entities.Shopuser;
import com.dcafe.order.repos.ShopuserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	ShopuserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String shopuserid) throws UsernameNotFoundException {
		
		Shopuser shopuser = userRepository.findByShopUserId(shopuserid);
		
		if(shopuser==null) {
			throw new UsernameNotFoundException("User not Found for email: " + shopuserid);
		}
		
		UserDetails userDetials = new org.springframework.security.core.userdetails.User(shopuser.getShopUserId(), shopuser.getPassword(), shopuser.getRoles());
		return userDetials;
	}

}
