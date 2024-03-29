package com.mindtree.service;

import com.mindtree.entity.Product;

public interface ProductService {

	Product findByProductId(Integer productId);

	Product findByProductName(String productName);

	Product findByCategory(String category);

}
