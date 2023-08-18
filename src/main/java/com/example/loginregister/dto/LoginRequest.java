package com.example.loginregister.dto;

import lombok.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    private String username;
    private String password;
}
