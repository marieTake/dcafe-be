package com.dcafe.order.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcafe.order.entities.Shopuser;

public interface ShopuserRepository extends JpaRepository<Shopuser, Integer> {
	
	public Shopuser findByShopUserId(String shopUserId);

}
