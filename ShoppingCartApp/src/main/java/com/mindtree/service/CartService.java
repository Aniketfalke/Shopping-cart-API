package com.mindtree.service;

import com.mindtree.entity.MyCart;

public interface CartService {

	MyCart saveCart(MyCart cart, Integer userId);

	MyCart findByCartId(Integer cartId);

}
