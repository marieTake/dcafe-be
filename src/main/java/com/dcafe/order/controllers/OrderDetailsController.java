package com.dcafe.order.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dcafe.order.entities.OrderDetails;
import com.dcafe.order.repos.OrderDetailsRepository;

@RestController
@CrossOrigin
@RequestMapping("/orderdetails")
public class OrderDetailsController {
	
	private OrderDetailsRepository repository;
	
	@Autowired
	OrderDetailsController(OrderDetailsRepository repository){
		this.repository = repository;
	}
	
	@RequestMapping(value="/getorderdetails", method=RequestMethod.GET)
	public List<OrderDetails> getOrderDetails(){
		return repository.findAll();
	}
	
	@RequestMapping(value="/getorderdetail/{id}")
	public OrderDetails getOrderDetails(@PathVariable("id") int id) {
		return repository.findById(id).get();
	}
	
	@RequestMapping(value="/saveorderdetail", method=RequestMethod.POST)
	public OrderDetails saveOrderDetails(@RequestBody OrderDetails orderDetail) {
		return repository.save(orderDetail);
	}
	

}
