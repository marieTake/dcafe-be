package com.dcafe.order.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class MenuItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int miid;
	
	private String menuName;
	
	private double price;
	
	private String description;
	
	private int cid;
	
	private String shop_admin_id;
	
	private int shop_id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cid", nullable=false, insertable = false, updatable = false)
	private CategoryTable categoryTable;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="menuItem")
	private List<OrderDetails> orderDetails;

	public int getMenuItemId() {
		return miid;
	}

	public void setMenuItemId(int menuItemId) {
		this.miid = menuItemId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getShop_admin_id() {
		return shop_admin_id;
	}

	public void setShop_admin_id(String shop_admin_id) {
		this.shop_admin_id = shop_admin_id;
	}

	public int getCid() {
		return cid;
	}

	public void setCidd(int categoryId) {
		this.cid = categoryId;
	}
	
	public int getShop_id() {
		return shop_id;
	}

	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;

	}

	@Override
	public String toString() {
		return "MenuItem [miid=" + miid + ", menuName=" + menuName + ", price=" + price + ", description=" + description
				+ ", cid=" + cid + ", shop_admin_id=" + shop_admin_id + ", shop_id=" + shop_id + ", category="
				+ categoryTable + ", orderDetails=" + orderDetails + "]";
	}
	
	

}
