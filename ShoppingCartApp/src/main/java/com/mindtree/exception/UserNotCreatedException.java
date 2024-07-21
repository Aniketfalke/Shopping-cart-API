package com.mindtree.exception;

public class UserNotCreatedException extends RuntimeException{

    public UserNotCreatedException(String msg){
        super(msg);
    }
}
