package com.mindtree.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.dao.ProductDao;
import com.mindtree.entity.Product;
import com.mindtree.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	private ProductDao productDao;
	
	public Product findByProductId(Integer productId) {
		// TODO Auto-generated method stub
		return productDao.findByProductId(productId);
	}

	public Product findByProductName(String productName) {
		// TODO Auto-generated method stub
		return productDao.findByProductName(productName);
	}

	public Product findByCategory(String category) {
		// TODO Auto-generated method stub
		return productDao.findByCategory(category);
	}

}
