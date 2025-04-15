package com.app.order.service;

import org.springframework.stereotype.Component;

import com.app.order.client.ProductServiceClient;
import com.app.order.entity.ProductEntity;

@Component
public class ProductServiceFallback implements ProductServiceClient {

	@Override
	public ProductEntity getProductById(Long id) {
		ProductEntity entity = new ProductEntity();
		entity.setId(id);
		entity.setName("Not-Available");
		entity.setPrice(0.0);
		return entity;
	}

}
