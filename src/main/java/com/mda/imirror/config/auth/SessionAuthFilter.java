package com.mda.imirror.config.auth;

import com.mda.imirror.domain.entity.Member;
import com.mda.imirror.exception.UnAuthorizedException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

import static java.util.Objects.isNull;


public class SessionAuthFilter extends OncePerRequestFilter{

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {
        try {
            if (request.getRequestURI().contains("/api/auth") || (request.getRequestURI().contains("/api/user/checkup") && request.getMethod().equals("POST"))) {
                filterChain.doFilter(request, response);
                return;
            }
            Member user = (Member) request.getSession(false).getAttribute("member");

            if (!isNull(user)) {
                Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, Collections.singleton(new SimpleGrantedAuthority(user.getRole())));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            throw new UnAuthorizedException();
        }
    }

}