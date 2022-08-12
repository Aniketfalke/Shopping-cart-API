package com.mindtree.dao;

import com.mindtree.entity.MyCart;

public interface CartDao {

	MyCart findByCartId(Integer cartId);

	MyCart save(MyCart cart);

}
