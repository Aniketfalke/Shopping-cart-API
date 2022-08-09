package com.mindtree.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.entity.CartItem;
import com.mindtree.entity.MyCart;
import com.mindtree.entity.User;
import com.mindtree.repository.CartRepo;
import com.mindtree.repository.UserRepo;

@Service
public class CartService {
	
	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private UserRepo userRepo;

	public MyCart findByCartId(Integer cartId) {
		// TODO Auto-generated method stub
		MyCart cart= cartRepo.findByCartId(cartId);
		/*
		 * set subprice in cartItem
		 */
		cart.getCartIteam().stream().forEach(cartItem->cartItem.setSubPrice(cartItem.getProduct().getPrice()));
		
		/*
		 * set total price
		 */
		float tempTotalPrice=0;
		for (CartItem cartItem: cart.getCartIteam()) {
			
			tempTotalPrice+=(cartItem.getSubPrice()*cartItem.getQuantity());
		}
		cart.setTotalPrice(tempTotalPrice);
		return cart;
	}



	public MyCart saveCart(MyCart cart, Integer userId) {
		// TODO Auto-generated method stub
		User user=userRepo.findByUserId(userId);
		cart.setUser(user);
		return cartRepo.save(cart);
	}
	

}
