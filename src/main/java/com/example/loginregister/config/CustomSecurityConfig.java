package com.example.loginregister.config;


import com.example.loginregister.filter.ApiAuthenticationFilter;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Log4j2
@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class CustomSecurityConfig {
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf( custom
                        -> custom.disable())    //csrf 토큰의 비활성화
                //.exceptionHandling(exception -> exception.authenticationEntryPoint(/**/)) //접근 거부된 유저들을 다른 페이지로 forward 하는 것으로, 필요 없는 코드

                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //세션을 사용하지 않음

                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/**").hasRole("USER")
                                .requestMatchers("/admin").hasRole("ADMIN").anyRequest().authenticated()); // "/admin 경로는 ADMIN 역할을 가진 사용자만 접근 가능
                                                                                                             // 그 외의 경로는 USER 역할을 가진 사용자만 접근 가능
                                                                                                             // 모든 요청은 인증된 사용자만 접근 가능
        http.authenticationProvider();

        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(AuthenticationConfiguration authConfig)  throws Exception{
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);

    }
}
