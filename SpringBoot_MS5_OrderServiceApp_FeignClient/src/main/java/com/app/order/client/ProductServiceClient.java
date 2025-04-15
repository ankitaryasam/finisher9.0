package com.app.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.order.entity.ProductEntity;
import com.app.order.service.ProductServiceFallback;

import jakarta.ws.rs.Path;

@FeignClient(name = "product-service", fallback = ProductServiceFallback.class)
public interface ProductServiceClient {
	
	@GetMapping("/products/{id}")
	ProductEntity getProductById(@PathVariable Long id);

}
