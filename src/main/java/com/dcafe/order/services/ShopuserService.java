package com.dcafe.order.services;

import com.dcafe.order.entities.Shopuser;

public interface ShopuserService {

	Shopuser findShopuser(String shopuserId, String password);
}
