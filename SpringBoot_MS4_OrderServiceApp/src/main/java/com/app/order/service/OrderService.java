package com.app.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.order.entity.OrderEntity;
import com.app.order.repo.OrderRepo;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepo orderRepo;
	
	public OrderEntity addOrder(OrderEntity entity) {
		return orderRepo.save(entity);
	}
	
	public OrderEntity getOrderById(Long id) {
		return orderRepo.findById(id).get();
	}

}
