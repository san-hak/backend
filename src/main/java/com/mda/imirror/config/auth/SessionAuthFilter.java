package com.mda.imirror.config.auth;

import com.mda.imirror.exception.UnAuthorizedException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


public class SessionAuthFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String[] swaggerUrl = new String[]{
//                "/swagger-ui.html",
//                "/swagger-resources/**",
//                "/swagger-ui/index.html",
//                "/swagger-ui/**",
//                "/v3/api-docs/**",
//                "/api-docs/swagger-config"
//        };
//
        if (request.getMethod().equals("OPTIONS") || request.getRequestURI().contains("/api/auth") || (request.getRequestURI().contains("/api/user/checkup" ) && request.getMethod().equals("POST"))) {
            filterChain.doFilter(request, response);
            return;
        }


        HttpSession session = request.getSession(false);;
        if (session == null) {
            throw new UnAuthorizedException();
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
