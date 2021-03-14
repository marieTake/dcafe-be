package com.dcafe.order.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dcafe.order.entities.OrderDetails;
import com.dcafe.order.entities.Orders;
import com.dcafe.order.repos.OrderDetailsRepository;
import com.dcafe.order.repos.OrdersRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	private OrdersRepository repository;
	private OrderDetailsRepository orderDetailsRepository;
	
	@Autowired
	OrderController(OrdersRepository repository, OrderDetailsRepository orderDetailsRepository){
		this.repository = repository;
		this.orderDetailsRepository = orderDetailsRepository;
	}

	@RequestMapping(value="/getorders", method=RequestMethod.GET)
	public List<Orders> getOrders(){
		return repository.findAll();
	}
	
	@RequestMapping(value="/getorder/{id}")
	public Orders getOrder(@PathVariable("id") int id) {
		return repository.findById(id).get();
	}
	
	@Transactional
	@RequestMapping(value="/saveorder", method=RequestMethod.POST)
	public String saveOrder(@RequestBody Orders request) {
		System.out.println("Orders: "+request.toString());
		Orders order=repository.save(request);
		List<OrderDetails> listofdetails = request.getOrderDetails();
		for(OrderDetails orderdetail : listofdetails) {
			orderdetail.setOrderId(order.getOid());
			OrderDetails saved = orderDetailsRepository.save(orderdetail);
			System.out.println(order);
			System.out.println(saved);
		}
        return "saved";  
	}
}
