package com.mindtree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.entity.Product;
import com.mindtree.repository.ProductRepo;
import com.mindtree.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/get/id/{id}")
	public Product getProductById(@PathVariable ("id")Integer productId) {
		return productService.findByProductId(productId);
		
	}
	
	@GetMapping("/get/name/{name}")
	public Product getProductByName(@PathVariable ("name") String productName) {
		return productService.findByProductName(productName);
	}
	
	@GetMapping("/get/category/{category}")
	public Product getProductByCategory(@PathVariable("category") String category) {
		return productService.findByCategory(category);
	}

}
