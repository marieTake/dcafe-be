package com.dcafe.order.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcafe.order.entities.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {
	
	public List<MenuItem> findByCid(int id);

	public List<MenuItem> findByShopId(int shopid);

	public List<MenuItem> findByShopIdAndCid(int shopid, int id);
	
	

}
