package com.mindtree.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.dao.CartDao;
import com.mindtree.dao.CartItemDao;
import com.mindtree.dao.ProductDao;
import com.mindtree.entity.CartItem;
import com.mindtree.entity.MyCart;
import com.mindtree.entity.Product;
import com.mindtree.repository.CartItemRepo;
import com.mindtree.repository.CartRepo;
import com.mindtree.repository.ProductRepo;
import com.mindtree.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {
	@Autowired
	private CartItemDao cartItemDao;
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private ProductDao productDao;
	public CartItem saveCartItem(CartItem cartItem,Integer cartId,Integer productId) {
		
		/*
		 * Cheking product is already added or not 
		 */
		 
		 CartItem tempCartItem=cartItemDao.findByProductIdAndCartId(productId,cartId);
		
		if(tempCartItem!=null) {
			tempCartItem.setQuantity( tempCartItem.getQuantity()+1);
			return cartItemDao.save(tempCartItem);
		}
		MyCart cart=cartDao.findByCartId(cartId);
		
		 cartItem.setCart(cart);
		
	    Product product=productDao.findByProductId(productId);
	    
		cartItem.setProduct(product);
		cartItem.setSubPrice(product.getPrice());
		return cartItemDao.save(cartItem);
	}
	public String deleteProductFromCartItem(Integer productId) {
		// TODO Auto-generated method stub
		
		 CartItem cartItem= cartItemDao.findByProductId(productId);
		 
		 cartItemDao.delete(cartItem);
		
			return "Deleted Successfully";
	}
	public String deleteAllProductFromCartItem(Integer cartId) {
		// TODO Auto-generated method stub
		List<CartItem> cartItems=cartItemDao.findByCardId(cartId);
		cartItemDao.deleteAll(cartItems);
		return "Delected Successfully";
	}
	public String updateProductQuantity(CartItem cartItem,Integer cartId,Integer productId) {
		// TODO Auto-generated method stub
		CartItem tempCartItem=cartItemDao.findByProductIdAndCartId(productId, cartId);
		if(cartItem.getQuantity()==0) {
			cartItemDao.delete(tempCartItem);
			return"updated successufully";
		}
		tempCartItem.setQuantity(cartItem.getQuantity());
		cartItemDao.save(tempCartItem);
		return "updated successfully";
	}

}
