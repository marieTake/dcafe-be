package com.dcafe.order.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderDetailsId;
	
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="menu_item_id")	
	private int menuItemId;
	
	private int orderAmount;
	
	private String size;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="order_id", nullable=false, insertable = false, updatable = false)
	private Orders orders;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="menu_item_id", nullable=false, insertable = false, updatable = false)
	private MenuItem menuItem;

	public int getOrderDetailsId() {
		return orderDetailsId;
	}

	public void setOrderDetailsId(int orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getMenuItemId() {
		return menuItemId;
	}

	public void setMenuItemId(int menuItemId) {
		this.menuItemId = menuItemId;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderDetailsId=" + orderDetailsId + ", orderId=" + orderId + ", menuItemId=" + menuItemId
				+ ", orderAmount=" + orderAmount + ", size=" + size + ", orders=" + orders + ", menuItem=" + menuItem
				+ "]";
	}

	
	
	
	

}
