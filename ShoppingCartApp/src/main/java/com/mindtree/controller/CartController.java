package com.mindtree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.entity.MyCart;
import com.mindtree.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping("/save/{id}")
	public MyCart saveCart(@RequestBody MyCart cart,@PathVariable ("id") Integer userId) {
		
		return cartService.saveCart(cart,userId);
	}
	@GetMapping("/get/{id}")
	public MyCart getCartById(@PathVariable ("id")Integer cartId) {
		return cartService.findByCartId(cartId);
	}
	

	
}
