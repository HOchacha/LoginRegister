package com.example.loginregister.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
/*
@RequiredArgsConstructor
@Configuration
@OpenAPIDefinition(info = @Info(title = "", description = "", version = ""))
public class SwaggerConfig {
    @Bean
    public OpenAPI OpenApi(){
        String[] paths = {"/api/auth", "/api/test"};
        return new OpenAPI();
    }
}
*/