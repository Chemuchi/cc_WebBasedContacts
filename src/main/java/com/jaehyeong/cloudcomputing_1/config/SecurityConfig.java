/*
package com.jaehyeong.cloudcomputing_1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // CSRF 비활성화
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/login", "/register", "/api/auth/login", "/api/auth/register").permitAll() // 로그인, 회원가입 허용
                        .anyRequest().authenticated() // 그 외 모든 경로는 인증 필요
                )
                .formLogin((form) -> form
                        .loginPage("/login") // 사용자 정의 로그인 페이지 경로 설정
                        .loginProcessingUrl("/api/auth/login") // 로그인 처리를 위한 URL 설정 (HTML 폼의 action과 동일)
                        .defaultSuccessUrl("/", true) // 로그인 성공 시 이동할 URL
                        .usernameParameter("email")
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .permitAll()
                        .invalidateHttpSession(true)
                );
        return http.build();
    }
}
*/
