package com.mindtree.service.impl;

import java.util.List;
import java.util.Optional;

import com.mindtree.exception.CartItemDoesNotExistException;
import com.mindtree.exception.CartNotAssociatedException;
import com.mindtree.exception.ProductDoesNotExistException;
import com.mindtree.utils.ExceptionConstants;
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

    public CartItem saveCartItem(CartItem cartItem, Integer cartId, Integer productId) {

        /*
         * Cheking product is already added or not
         */

        CartItem tempCartItem = cartItemDao.findByProductIdAndCartId(productId, cartId);

        if (tempCartItem != null) {
            tempCartItem.setQuantity(tempCartItem.getQuantity() + 1);
            return cartItemDao.save(tempCartItem);
        }
        MyCart cart = cartDao.findByCartId(cartId);
        if (cart == null) {
            throw new CartNotAssociatedException(ExceptionConstants.CART_MISSING_IN_CART_ITEM_REQUEST);
        }

        cartItem.setCart(cart);

        Product product = productDao.findByProductId(productId);
        if (product == null) {
            throw new ProductDoesNotExistException(ExceptionConstants.PRODUCT_MISSING_IN_CART_ITEM_REQUEST);
        }

        cartItem.setProduct(product);
        cartItem.setSubPrice(product.getPrice());
        return cartItemDao.save(cartItem);
    }

    public String deleteProductFromCartItem(Integer productId) {
        // TODO Auto-generated method stub

        Optional<CartItem> cartItem = Optional.ofNullable((cartItemDao.findByProductId(productId)));

        if (!cartItem.isPresent()) {
            throw new ProductDoesNotExistException(ExceptionConstants.PRODUCT_ID_INVALID_DELETE_REQUEST);
        }

        cartItemDao.delete(cartItem.get());

        return "Deleted Successfully";
    }

    public String deleteAllProductFromCartItem(Integer cartId) {
        // TODO Auto-generated method stub
        List<CartItem> cartItems = cartItemDao.findByCardId(cartId);
		if(cartItems==null) {
			throw new CartItemDoesNotExistException(ExceptionConstants.CART_ID_INVALID_DELETE_REQUEST);
		}
		cartItemDao.deleteAll(cartItems);
		return "Delected Successfully";
    }

    public String updateProductQuantity(CartItem cartItem, Integer cartId, Integer productId) {
        // TODO Auto-generated method stub
		if(cartItem.getQuantity()<0) {
			return "Quantity should not be negative";
		}
		Optional<CartItem> existingCartItem=Optional.of(cartItemDao.findByProductIdAndCartId(productId, cartId));
		if(existingCartItem.isPresent()) {
			throw new CartItemDoesNotExistException(ExceptionConstants.CART_ITEM_MISSING_IN_REQUEST);
		}

		if(cartItem.getQuantity()==0) {
			cartItemDao.delete(existingCartItem.get());
			return"updated successfully";
		}
		existingCartItem.get().setQuantity(cartItem.getQuantity());
		cartItemDao.save(existingCartItem.get());
		return "updated successfully";
    }

}
