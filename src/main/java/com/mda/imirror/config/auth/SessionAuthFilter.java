package com.mda.imirror.config.auth;

import com.mda.imirror.domain.entity.Member;
import com.mda.imirror.exception.UnAuthorizedException;
import com.mda.imirror.exception.UnknownServerException;
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
//        System.out.println(request.getHeader("Authorization"));
        System.out.println(request.getRequestURI());
//        System.out.println(authKey.token);



        try {
            // 인증, 검사 결과 endpoint는 허용
            if (request.getRequestURI().contains("/api/auth")) {
                filterChain.doFilter(request, response);
                return;
            }

            try {
                if (request.getHeader("Authorization").equals(authKey.token)) {
//              System.out.println(authKey.token);
                    filterChain.doFilter(request, response);
                    return;
                }
            } catch (NullPointerException nullPointerException) {
                System.out.println(nullPointerException.getMessage());
            }
            // 인증, 검사 결과 endpoint는 허용



            Member user = null;
            try {
                user = (Member) request.getSession(false).getAttribute("member");
            } catch (NullPointerException nullPointerException) {
                throw new UnAuthorizedException();
            }

            System.out.println(user);

            if (!isNull(user)) {
                Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, Collections.singleton(new SimpleGrantedAuthority(user.getRole())));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

            filterChain.doFilter(request, response);

        } catch (IOException | ServletException e) {
            System.out.println(e.getMessage());
            throw new UnknownServerException();
        }
    }

}