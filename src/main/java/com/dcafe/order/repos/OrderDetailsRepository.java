package com.dcafe.order.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcafe.order.entities.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {

}
