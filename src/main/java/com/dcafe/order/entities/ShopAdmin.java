package com.dcafe.order.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="shop_admin")
public class ShopAdmin {
	
	@Id
	private int sid;
	
	private String shopName;

	@OneToOne(mappedBy = "shopAdmin")
	private ShopUser shopUser;
	
	public int getSid() {
		return sid;
	}

	public void setSid(int shopId) {
		this.sid = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
	public ShopUser getShopUser() {
		return shopUser;
	}

	public void setShopUser(ShopUser shopUser) {
		this.shopUser = shopUser;
	}

	@Override
	public String toString() {
		return "ShopAdmin [sid=" + sid + ", shopName=" + shopName + ", shopuser=" + shopUser + "]";
	}

	
	
	
	

}
