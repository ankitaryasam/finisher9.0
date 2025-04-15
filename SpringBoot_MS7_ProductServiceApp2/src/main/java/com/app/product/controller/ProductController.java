package com.app.product.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.product.dto.ProductDto;
import com.app.product.entity.ProductEntity;
import com.app.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/add-product")
	public ProductEntity addProduct(@RequestBody ProductEntity entity) {
		return service.saveNewProduct(entity);
	}
	
	@GetMapping("/get-product/{id}")
	public ProductDto getProduct(@PathVariable Long id) {
		
		ProductEntity entity = service.getProductDetails(id);
		ProductDto dto = new ProductDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	
	
	
	
	
	
	
	

}
