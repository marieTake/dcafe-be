package com.dcafe.order.dto;

import java.util.List;

public class DisplayOrderDetailsDTO {

	private String customerName;
	private List<DisplayOrderedItemDTO> displayOrderedItemDto;
	private Double totalPrice;
	private String email;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<DisplayOrderedItemDTO> getDisplayOrderedItemDto() {
		return displayOrderedItemDto;
	}

	public void setDisplayOrderedItemDto(List<DisplayOrderedItemDTO> displayOrderedItemDto) {
		this.displayOrderedItemDto = displayOrderedItemDto;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "DisplayOrderDetailsDTO [customerName=" + customerName + ", displayOrderedItemDto="
				+ displayOrderedItemDto + ", totalPrice=" + totalPrice + ", email=" + email + "]";
	}
	
	

}
