package com.mayousheng.www.exception;

public class UsernameDuplicateException extends RuntimeException{

    public UsernameDuplicateException(String message){
        super(message);
    }
}
