package com.mindtree.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.entity.Product;
import com.mindtree.repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	public Product findByProductId(Integer productId) {
		// TODO Auto-generated method stub
		return productRepo.findByProductId(productId);
	}

	public Product findByProductName(String productName) {
		// TODO Auto-generated method stub
		return productRepo.findByProductName(productName);
	}

	public Product findByCategory(String category) {
		// TODO Auto-generated method stub
		return productRepo.findByCategory(category);
	}

}
