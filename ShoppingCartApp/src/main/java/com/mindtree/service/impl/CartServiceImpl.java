package com.mindtree.service.impl;

import com.mindtree.exception.CartNotAssociatedException;
import com.mindtree.utils.ExceptionConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.dao.CartDao;
import com.mindtree.dao.UserDao;
import com.mindtree.entity.CartItem;
import com.mindtree.entity.MyCart;
import com.mindtree.entity.User;
import com.mindtree.repository.CartRepo;
import com.mindtree.repository.UserRepo;
import com.mindtree.service.CartService;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private UserDao userDao;

	public MyCart findByCartId(Integer cartId) {

		Optional<MyCart> cart= Optional.ofNullable(cartDao.findByCartId(cartId));
		if(!cart.isPresent()) {
			throw new CartNotAssociatedException(ExceptionConstants.CART_MISSING);
		}
		/*
		 * set subprice in cartItem
		 */
		cart.get().getCartIteam().stream().forEach(cartItem->cartItem.setSubPrice(cartItem.getProduct().getPrice()));

		/*
		 * set total price
		 */
		float tempTotalPrice=0;
		for (CartItem cartItem: cart.get().getCartIteam()) {

			tempTotalPrice+=(cartItem.getSubPrice()*cartItem.getQuantity());
		}
		cart.get().setTotalPrice(tempTotalPrice);
		return cart.get();
	}



	public MyCart saveCart(MyCart cart, Integer userId) {

		User user=userDao.findByUserId(userId);
		cart.setUser(user);
		return cartDao.save(cart);
	}
	

}
