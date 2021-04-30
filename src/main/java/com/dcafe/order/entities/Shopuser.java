package com.dcafe.order.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Shopuser{

	@Id
	private String shopAdminId;
	
	private String password;
	
	private String shopName;
	
	private String shopId;
	
	private String userEmail;
	
	@OneToOne
	@JoinColumn(name = "shopId", referencedColumnName = "sid", nullable=false, insertable = false, updatable = false)
	public ShopAdmin shopAdmin;

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

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public ShopAdmin getShopadmin() {
		return shopAdmin;
	}

	public void setShopadmin(ShopAdmin shopadmin) {
		this.shopAdmin = shopadmin;
	}

	
}
