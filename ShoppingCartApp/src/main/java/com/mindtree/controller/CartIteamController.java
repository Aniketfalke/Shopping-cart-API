package com.mindtree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.entity.CartItem;
import com.mindtree.entity.MyCart;
import com.mindtree.service.CartItemService;
import com.mindtree.service.CartService;
import com.mindtree.service.UserService;

@RestController

public class CartIteamController {
	
	@Autowired
	private CartItemService cartItemService;
	
	
	@PostMapping("cart/{cartId}/product/{productId}/add")
	public CartItem saveCartItem(@RequestBody CartItem cartIteam,@PathVariable Integer cartId,@PathVariable("productId") Integer productId) {
		
		return cartItemService.saveCartItem(cartIteam,cartId,productId);
		
	}

	@DeleteMapping("/cart/delete/{id}")
	public String deleteProductFromCart(@PathVariable("id") Integer productId) {
		
		return cartItemService.deleteProductFromCartItem(productId);
	}
	@DeleteMapping("/cart/delete/all/{cartId}")
	public String deleteAllProductFromCart(@PathVariable Integer cartId) {
		return cartItemService.deleteAllProductFromCartItem(cartId);
		
	}
	
	@PutMapping("/cart/update/{cartId}/product/{id}")
	public String updateProductQuantity(@RequestBody CartItem cartItem, @PathVariable ("id") Integer ProductId,
			@PathVariable ("cartId")Integer cartId) {
		return cartItemService.updateProductQuantity(cartItem,cartId,ProductId);
	}
	
}
