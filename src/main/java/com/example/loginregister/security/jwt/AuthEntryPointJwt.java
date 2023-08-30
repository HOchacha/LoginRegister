package com.example.loginregister.security.jwt;

import com.example.loginregister.exception.ExpiredJwtTokenException;
import com.example.loginregister.exception.InvalidJwtTokenException;
import com.example.loginregister.exception.InvalidJwtTokenExceptionImpl;
import com.example.loginregister.exception.UnsupportedJwtExceptionImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Component
@Log4j2
public class AuthEntryPointJwt implements AuthenticationEntryPoint {
    private final HandlerExceptionResolver resolver;

    @Autowired
    public AuthEntryPointJwt(@Qualifier("handlerExceptionResolver") HandlerExceptionResolver handlerExceptionResolver) {
        log.info(handlerExceptionResolver);
        this.resolver = handlerExceptionResolver;
    }
    /*
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        log.info(authException);
        resolver.resolveException(request, response, null, authException);
    }
    */

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        log.error("Unauthorized error: " + authException.getMessage(), authException);
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized");
    }
}
