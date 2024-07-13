package com.mindtree.exception;

public class CartItemDoesNotExistException extends RuntimeException{

    public CartItemDoesNotExistException(String message) {
        super(message);
    }
}
