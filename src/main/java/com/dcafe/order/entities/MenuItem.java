package com.dcafe.order.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	@Column(name="menu_item_id")
	private int menuItemId;
	
	private String menuName;
	
	private double price;
	
	private String description;
	
	@Column(name="category_id")
	private int categoryId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="category_id", nullable=false, insertable = false, updatable = false)
	private Category category;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="menuItem")
	private List<OrderDetails> orderDetails;

	public int getMenuItemId() {
		return menuItemId;
	}

	public void setMenuItemId(int menuItemId) {
		this.menuItemId = menuItemId;
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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "MenuItem [menuItemId=" + menuItemId + ", menuName=" + menuName + ", price=" + price + ", description="
				+ description + ", categoryId=" + categoryId + "]";
	}
	
	

}
