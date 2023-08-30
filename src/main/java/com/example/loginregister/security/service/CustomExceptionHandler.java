package com.example.loginregister.security.service;

import com.example.loginregister.payload.response.ExceptionResponse;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.security.SignatureException;

@RestControllerAdvice
@Log4j2
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<?> handleExpiredException(ExpiredJwtException e){
        log.info(e);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ExceptionResponse(HttpStatus.UNAUTHORIZED.toString(),e.getMessage()));
    }

    @ExceptionHandler(SignatureException.class)
    public ResponseEntity<?> handleSignatureException() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ExceptionResponse(HttpStatus.UNAUTHORIZED.toString(),"Wrong Signiture, Invalid JWT Token"));
    }

    @ExceptionHandler(MalformedJwtException.class)
    public ResponseEntity<?> handleMalformedJwtException(){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ExceptionResponse(HttpStatus.UNAUTHORIZED.toString(),"Invalid JWT Token"));
    }

    @ExceptionHandler(UnsupportedJwtException.class)
    public ResponseEntity<?> handleUnsupportedException(){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ExceptionResponse(HttpStatus.UNAUTHORIZED.toString(), "JWT token is unsupported"));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ExceptionResponse(HttpStatus.UNAUTHORIZED.toString(), "JWT claim string is empty"));
    }
}
