package com.mindtree.service.impl;

import com.mindtree.exception.ProductDoesNotExistException;
import com.mindtree.utils.ExceptionConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.dao.ProductDao;
import com.mindtree.entity.Product;
import com.mindtree.service.ProductService;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	private ProductDao productDao;
	
	public Product findByProductId(Integer productId) {
		Optional<Product> existingProduct= Optional.of(productDao.findByProductId(productId));
		if(existingProduct.isPresent()) {
			throw new ProductDoesNotExistException(ExceptionConstants.INVALID_PRODUCT_ID_IN_REQUEST);
		}
		return existingProduct.get();
	}

	public Product findByProductName(String productName) {
		Optional<Product> existingProduct=Optional.ofNullable(productDao.findByProductName(productName));
		if(!existingProduct.isPresent()) {
			throw new ProductDoesNotExistException(ExceptionConstants.INVALID_PRODUCT_NAME_IN_REQUEST);
		}
		return existingProduct.get();
	}

	public Product findByCategory(String category) {
		Optional<Product>existingProduct= Optional.ofNullable(productDao.findByCategory(category));
		if(!existingProduct.isPresent()) {
			throw new ProductDoesNotExistException(ExceptionConstants.INVALID_CATEGORY_NAME_IN_REQUEST);
		}
		return existingProduct.get();
	}

}
