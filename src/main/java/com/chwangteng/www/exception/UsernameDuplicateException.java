package com.chwangteng.www.exception;

public class UsernameDuplicateException extends RuntimeException{

    public UsernameDuplicateException(String message){
        super(message);
    }
}
