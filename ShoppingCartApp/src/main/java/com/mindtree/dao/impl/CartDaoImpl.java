package com.mindtree.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mindtree.dao.CartDao;
import com.mindtree.entity.MyCart;
import com.mindtree.repository.CartRepo;


@Component
public class CartDaoImpl implements CartDao{
	
    @Autowired
    private CartRepo cartRepo;
	
	@Override
	public MyCart findByCartId(Integer cartId) {
		// TODO Auto-generated method stub
		return cartRepo.findByCartId(cartId);
	}

	@Override
	public MyCart save(MyCart cart) {
		// TODO Auto-generated method stub
		return cartRepo.save(cart);
	}

}
