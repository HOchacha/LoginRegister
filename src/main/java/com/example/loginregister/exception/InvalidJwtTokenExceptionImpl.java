package com.example.loginregister.exception;

public class InvalidJwtTokenExceptionImpl extends RuntimeException {
    public InvalidJwtTokenExceptionImpl(){}
    public InvalidJwtTokenExceptionImpl(String message) {
        super(message);
    }
}
