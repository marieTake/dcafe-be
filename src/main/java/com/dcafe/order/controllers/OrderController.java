package com.dcafe.order.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dcafe.order.entities.Orders;
import com.dcafe.order.repos.OrdersRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	private OrdersRepository repository;
	
	@Autowired
	OrderController(OrdersRepository repository){
		this.repository = repository;
	}

	@RequestMapping(value="/getorders", method=RequestMethod.GET)
	public List<Orders> getOrders(){
		return repository.findAll();
	}
	
	@RequestMapping(value="/getorder/{id}")
	public Orders getOrder(@PathVariable("id") int id) {
		return repository.findById(id).get();
	}
	
	@RequestMapping(value="/saveorder", method=RequestMethod.POST)
	public Orders saveOrder(@RequestBody Orders order) {
		return repository.save(order);
	}
}
