package com.mindtree.service;

import com.mindtree.entity.CartItem;

public interface CartItemService {

	CartItem saveCartItem(CartItem cartIteam, Integer cartId, Integer productId);

	String deleteProductFromCartItem(Integer productId);

	String deleteAllProductFromCartItem(Integer cartId);

	String updateProductQuantity(CartItem cartItem, Integer cartId, Integer productId);

}
