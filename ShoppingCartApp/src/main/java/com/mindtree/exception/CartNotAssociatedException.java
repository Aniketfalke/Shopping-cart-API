package com.mindtree.exception;

public class CartNotAssociatedException extends RuntimeException{

    public CartNotAssociatedException(String message) {
        super(message);
    }
}
