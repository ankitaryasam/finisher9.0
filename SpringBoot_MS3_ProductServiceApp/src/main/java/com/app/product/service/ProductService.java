package com.app.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.product.entity.ProductEntity;
import com.app.product.repo.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	public ProductEntity addProduct(ProductEntity entity) {
		return productRepo.save(entity);
	}
	
	public ProductEntity getProductById(Long id) {
		return productRepo.findById(id).get();
	}

}
