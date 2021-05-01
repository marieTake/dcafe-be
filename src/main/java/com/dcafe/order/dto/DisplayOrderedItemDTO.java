package com.dcafe.order.dto;

public class DisplayOrderedItemDTO {

	private String menuItem;
	private int amount;
	private Double price;

	public String getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(String menuItem) {
		this.menuItem = menuItem;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "DisplayOrderedItemDTO [menuItem=" + menuItem + ", amount=" + amount + ", price=" + price + "]";
	}
	
	

}
