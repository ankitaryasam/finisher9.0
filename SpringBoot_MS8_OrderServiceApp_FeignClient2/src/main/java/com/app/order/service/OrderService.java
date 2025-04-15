package com.app.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.order.client.ProductClient;
import com.app.order.client.ProductServiceClient;
import com.app.order.entity.OrderEntity;
import com.app.order.entity.ProductEntity;
import com.app.order.repo.OrderRepo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public class OrderService {
	
	@Autowired
	private ProductClient  productClient;
	
	@Autowired
	private OrderRepo orderRepo;
	
	
	public String placeOrder(Long productId) {
		ProductEntity productEntity = productClient.getProductById(productId);
		
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setProductId(productEntity.getId());
		orderEntity.setQty(1);
		OrderEntity savedOrder = orderRepo.save(orderEntity);
		return "Order is placed. Order id is " + savedOrder.getId();
	}
	

}
