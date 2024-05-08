package com.mda.imirror.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.*;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final String[] SWAGGER_PATH = {
            "/swagger-ui.html",
            "/swagger-resources/**",
            "/swagger-ui/index.html",
            "/swagger-ui/**",
            "/v3/api-docs/**"
    };

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) ->
                web.ignoring().requestMatchers(SWAGGER_PATH);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(CsrfConfigurer::disable)
                .formLogin(FormLoginConfigurer::disable)
                .authorizeHttpRequests(authorizeRequest -> {
                    authorizeRequest
                            .requestMatchers("/api/auth/**").permitAll()
                            .requestMatchers("/api/user/**").hasRole("USER")
                            .requestMatchers("/api/admin/**").hasRole("ADMIN")
                            .anyRequest().permitAll();
                })
                .sessionManagement(securitySessionManagementConfigurer -> securitySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(HttpBasicConfigurer::disable)
                .cors(CorsConfigurer::disable) //프론트 배포 후 수정
        ;

        return http.build();
    }

}
