package com.app.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.order.entity.OrderEntity;
import com.app.order.entity.ProductEntity;
import com.app.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@PostMapping("/{productId}/{qty}")
	public OrderEntity placeNewOrder(@PathVariable Long productId, @PathVariable int qty) {
		//place order if there is a product
		
		ProductEntity product = restTemplate.getForObject("http://localhost:8081/products/" + productId, ProductEntity.class);
		
		if(product==null) {
			throw new RuntimeException("Product Not Found");
		}
		
		OrderEntity order = new OrderEntity();
		order.setProductId(productId);
		order.setQty(qty);
		return orderService.addOrder(order);
	}
	
	@GetMapping("/{id}")
	public OrderEntity getProduct(@PathVariable Long id) {
		return orderService.getOrderById(id);
	}
	
	
	

	
	
	
}
