package com.example.loginregister.exception;

public class ExpiredJwtTokenException extends RuntimeException{
    public  ExpiredJwtTokenException(){}
    public  ExpiredJwtTokenException(String message){
        super(message);
    }
}
