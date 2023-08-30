package com.example.loginregister.exception;

public class UnsupportedJwtExceptionImpl extends RuntimeException{
    public UnsupportedJwtExceptionImpl(){}
    public UnsupportedJwtExceptionImpl(String message) {super(message);}
}
