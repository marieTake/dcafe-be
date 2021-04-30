package com.dcafe.order.dto;

public class ShopUserLoginRequest {

	private String shopAdminId;
	private String password;

	public String getShopAdminId() {
		return shopAdminId;
	}

	public void setShopAdminId(String shopAdminId) {
		this.shopAdminId = shopAdminId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
