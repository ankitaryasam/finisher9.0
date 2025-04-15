package com.app.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.order.client.ProductServiceClient;
import com.app.order.entity.OrderEntity;
import com.app.order.entity.ProductEntity;
import com.app.order.repo.OrderRepo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class OrderService {
	
	
	@Autowired
	private ProductServiceClient productServiceClient;
	
	@Autowired
	private OrderRepo orderRepo;
	
	public OrderEntity addOrder(OrderEntity entity) {
		return orderRepo.save(entity);
	}
	
	
	public OrderEntity getOrderById(Long id) {
		return orderRepo.findById(id).get();
	}
	
	@HystrixCommand(fallbackMethod = "getFallbackProduct")
	public ProductEntity fetchProductByClient(Long id) {
		return productServiceClient.getProductById(id);
	}
	
	public ProductEntity getFallbackProduct(Long id) {
		ProductEntity entity = new ProductEntity();
		entity.setId(id);
		entity.setName("Not-Available");
		entity.setPrice(0.0);
		return entity;
	}
	
}
