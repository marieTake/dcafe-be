package com.dcafe.order.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int oid;
	
	private String customerName;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderTime;
	
	private String comment;
	
	private double totalPrice;
	
	private boolean eatinTakeout;
	
	private int shopId;
	
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.LAZY, mappedBy="orders")
	private List<OrderDetails> orderDetails = new ArrayList<>();
	
	@PrePersist
    public void onPrePersist() {
        setOrderTime(new Date());
    }
	
	public int getOid() {
		return oid;
	}

	public void setOid(int id) {
		this.oid = id;
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

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	@Override
	public String toString() {
		return "Orders [id=" + oid + ", customerName=" + customerName + ", orderTime=" + orderTime + ", comment="
				+ comment + ", totalPrice=" + totalPrice + ", eatinTakeout=" + eatinTakeout + ", orderDetails="
				+ orderDetails + "]";
	}
	
	
	
	

}
