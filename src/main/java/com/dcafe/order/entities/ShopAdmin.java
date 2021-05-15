package com.dcafe.order.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shop_admin")
public class ShopAdmin{

	@Id
	private String sid;
	
	private String shopName;

	public String getSid() {
		return sid;
	}

	public void setSid(String shopId) {
		this.sid = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	@Override
	public String toString() {
		return "ShopAdmin [sid=" + sid + ", shopName=" + shopName + "]";
	}
	
	

}
