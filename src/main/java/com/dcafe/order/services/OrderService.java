package com.dcafe.order.services;

import java.util.List;

import com.dcafe.order.dto.DisplayOrderDetailsDTO;
import com.dcafe.order.entities.OrderDetails;
import com.dcafe.order.entities.Orders;

public interface OrderService {
	
	public DisplayOrderDetailsDTO createDisplayOrderDetails(Orders orders, List<OrderDetails> listofdetails);

}
