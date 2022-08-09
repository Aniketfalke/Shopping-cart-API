package com.mindtree.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.controller.CartIteamController;
import com.mindtree.entity.CartItem;
import com.mindtree.entity.MyCart;
import com.mindtree.entity.Product;
import com.mindtree.repository.CartItemRepo;
import com.mindtree.repository.CartRepo;
import com.mindtree.repository.ProductRepo;

@Service
public class CartItemService {
	
	@Autowired
	private CartItemRepo cartItemRepo;
	
	@Autowired
	private CartService cartService;
	

	@Autowired
	private ProductRepo productRepo;
	public CartItem saveCartItem(CartItem cartItem,Integer cartId,Integer productId) {
		
		/*
		 * Cheking product is already added or not 
		 */
		 
		/* CartItem tempCartItem=cartItemRepo.findByProductIdAndCartId(productId,cartId);
		System.out.println(tempCartItem);
		if(tempCartItem!=null) {
			tempCartItem.setQuantity( tempCartItem.getQuantity()+1);
			return cartItemRepo.save(tempCartItem);
		}*/
		MyCart cart=cartService.findByCartId(cartId);
		System.out.println(cart);
		 cartItem.setCart(cart);
		
	    Product product=productRepo.findByProductId(productId);
	    System.out.println(product);
		cartItem.setProduct(product);
		cartItem.setSubPrice(product.getPrice());
		return cartItemRepo.save(cartItem);
	}
	public String deleteProductFromCartItem(Integer productId) {
		// TODO Auto-generated method stub
		
		 CartItem cartItem= cartItemRepo.findByProductId(productId);
		 
		 cartItemRepo.delete(cartItem);
		
			return "Deleted Successfully";
	}

}
