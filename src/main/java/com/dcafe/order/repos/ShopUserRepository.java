package com.dcafe.order.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcafe.order.entities.ShopUser;

public interface ShopUserRepository extends JpaRepository<ShopUser, Integer> {
	
	public ShopUser findByShopAdminId(String sai);

}
