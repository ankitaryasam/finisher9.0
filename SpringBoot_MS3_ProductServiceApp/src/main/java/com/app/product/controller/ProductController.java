package com.app.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.product.entity.ProductEntity;
import com.app.product.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@PostMapping
	public ProductEntity addNewProduct(@RequestBody ProductEntity entity) {
		return productService.addProduct(entity);
	}
	
	@GetMapping("/{id}")
	public ProductEntity getProduct(@PathVariable Long id) {
		return productService.getProductById(id);
	}
	
	
	

	
	
	
}
