package com.mindtree.service.impl;

import com.mindtree.entity.CartItem;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

class CartItemServiceImplTest {


    @MockBean
    private CartItemServiceImpl cartItemService;

    @Test
    void saveCartItem() {
        //Mockito.when(this.cartItemService).thenReturn(new CartItem(1,));
        assertTrue(true);
    }
}