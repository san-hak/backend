package com.mda.imirror.config.auth;

import com.mda.imirror.domain.entity.Member;
import com.mda.imirror.exception.UnAuthorizedException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.Objects;

import static java.util.Objects.isNull;

@RequiredArgsConstructor
public class SessionAuthFilter extends OncePerRequestFilter{

    private final AuthKey authKey;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {
//        System.out.println(Objects.equals(request.getHeader("Authorization"),token));
//        System.out.println(request.getHeader("Authorization"));
//        System.out.println(authKey.token);



        try {
            if (request.getRequestURI().contains("/api/auth") || request.getHeader("Authorization").equals(authKey.token)) {
//                System.out.println(authKey.token);
                filterChain.doFilter(request, response);
                return;
            }
            Member user = (Member) request.getSession(false).getAttribute("member");

            if (!isNull(user)) {
                Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, Collections.singleton(new SimpleGrantedAuthority(user.getRole())));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            filterChain.doFilter(request, response);
        } catch (NullPointerException | IOException | ServletException e) {
            System.out.println(e.getMessage());
            throw new UnAuthorizedException();
        }
    }

}