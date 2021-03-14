package com.dcafe.order.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcafe.order.entities.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

	public Orders findByOid(int oid);

}
