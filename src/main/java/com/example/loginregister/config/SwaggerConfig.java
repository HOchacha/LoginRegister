package com.example.loginregister.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.info.Info;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContext;

@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI(

    ) {

        Info info = new Info()
                .title("Bonheur API 문서") // 타이틀
                .version("v1") // 문서 버전
                .description("잘못된 부분이나 오류 발생 시 바로 말씀해주세요.") // 문서 설명
                .contact(new Contact() // 연락처
                        .name("Hwan")
                        .email("thirdshine@gmail.com"));

        return new OpenAPI()
                .info(info);
    }


}
