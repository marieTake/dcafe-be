package com.dcafe.order.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcafe.order.dto.DisplayOrderDetailsDTO;
import com.dcafe.order.dto.DisplayOrderedItemDTO;
import com.dcafe.order.entities.MenuItem;
import com.dcafe.order.entities.OrderDetails;
import com.dcafe.order.entities.Orders;
import com.dcafe.order.repos.MenuItemRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	MenuItemRepository menuItemRepository;

	@Override
	public DisplayOrderDetailsDTO createDisplayOrderDetails(Orders orders, List<OrderDetails> listofdetails) {
		DisplayOrderDetailsDTO displayOrderDetailsDTO = new DisplayOrderDetailsDTO();

		//customer name
		displayOrderDetailsDTO.setCustomerName(orders.getCustomerName());
		//total price
		displayOrderDetailsDTO.setTotalPrice(orders.getTotalPrice());
		
		//create DisplayOrderedItemDTO
		List<DisplayOrderedItemDTO> listOfOrderedItem = new ArrayList<DisplayOrderedItemDTO>();
		
		for (OrderDetails orderDetail: listofdetails) {
			DisplayOrderedItemDTO displayOrderedItemDTO = new DisplayOrderedItemDTO();
			//Fetch Menu Item Name and Price
			int menuItemId = orderDetail.getMenuItemId();
			MenuItem menuItem = menuItemRepository.findByMiid(menuItemId);
			//Set Menu Name and Price to displayOrderedItemDTO
			displayOrderedItemDTO.setMenuItem(menuItem.getMenuName());
			displayOrderedItemDTO.setPrice(menuItem.getPrice());
			
			//Fetch and Set Order Amount 
			displayOrderedItemDTO.setAmount(orderDetail.getOrderAmount());
			//Set displayOrderedItemDTO to the list 
			listOfOrderedItem.add(displayOrderedItemDTO);
		}
		
		displayOrderDetailsDTO.setDisplayOrderedItemDto(listOfOrderedItem);
		
		return displayOrderDetailsDTO;
	}

}
