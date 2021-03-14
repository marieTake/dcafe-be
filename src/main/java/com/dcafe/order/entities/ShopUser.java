package com.dcafe.order.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ShopUser {
	
	@Id
	@Column(name="shop_admin_id")
	private String shopAdminId;
	
	private String password;
	
	private String shopName;
	
	@Column(name="shop_id")
	private int shopId;
	
	private String userEmail;
	
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "shop_id", referencedColumnName = "sid", nullable=false, insertable = false, updatable = false)
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

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
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

	@Override
	public String toString() {
		return "ShopUser [shopAdminIdd=" + shopAdminId + ", password=" + password + ", shopName=" + shopName
				+ ", shopId=" + shopId + ", userEmail=" + userEmail + ", shopadmin=" + shopAdmin + "]";
	}

	
	

	
}
