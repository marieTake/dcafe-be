package com.dcafe.order.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Shopuser{

	@Id
	private String shopUserId;
	
	private String password;
	
	private String shopName;
	
	private String shopId;
	
	private String userEmail;
	
	@OneToOne
	@JoinColumn(name = "shopId", referencedColumnName = "sid", nullable=false, insertable = false, updatable = false)
	private ShopAdmin shopAdmin;
	
	@ManyToMany
	@JoinTable(name="user_role", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<Role> roles;

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getShopUserId() {
		return shopUserId;
	}

	public void setShopUserId(String shopUserId) {
		this.shopUserId = shopUserId;
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
