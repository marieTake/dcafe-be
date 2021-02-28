package com.dcafe.order.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcafe.order.entities.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {

}
