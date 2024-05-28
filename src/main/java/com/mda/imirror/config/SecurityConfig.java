package com.mda.imirror.config;

import com.mda.imirror.config.auth.SessionAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.*;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final String[] SWAGGER_PATH = {
            "/swagger-ui.html",
            "/swagger-resources/**",
            "/swagger-ui/index.html",
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/api-docs/swagger-config",
            "/api-docs"
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
                            .requestMatchers(HttpMethod.POST,"/api/user/checkup").permitAll()
                            .requestMatchers("/api/user/**").hasRole("USER")
                            .requestMatchers("/api/admin/**").hasRole("ADMIN")
                            .anyRequest().permitAll();
                })
                .sessionManagement(securitySessionManagementConfigurer -> securitySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .logout(LogoutConfigurer::disable)
                .httpBasic(HttpBasicConfigurer::disable)
                .cors(CorsConfigurer::disable) //프론트 배포 후 수정
                .addFilterBefore(new SessionAuthFilter(), UsernamePasswordAuthenticationFilter.class)
        ;

        return http.build();
    }

}
