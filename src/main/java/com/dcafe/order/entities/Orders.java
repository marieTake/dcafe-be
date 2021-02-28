package com.dcafe.order.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private int orderId;
	
	private String customerName;
	
	private Date orderTime;
	
	private String comment;
	
	private double totalPrice;
	
	private boolean eatinTakeout;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="order")
	private List<OrderDetails> orderDetails;
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean isEatinTakeout() {
		return eatinTakeout;
	}

	public void setEatinTakeout(boolean eatinTakeout) {
		this.eatinTakeout = eatinTakeout;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", customerName=" + customerName + ", orderTime=" + orderTime
				+ ", comment=" + comment + ", totalPrice=" + totalPrice + ", eatinTakeout=" + eatinTakeout + "]";
	}
	
	

}
