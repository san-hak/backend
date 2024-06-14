package com.mda.imirror.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mda.imirror.exception.CustomException;
import com.mda.imirror.exception.ExceptionResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
public class ExceptionHandlerFilter extends OncePerRequestFilter{
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (CustomException e) {
            ObjectMapper objectMapper = new ObjectMapper();
            response.setStatus(e.getStatus().value());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding("UTF-8");
            try {
                response.getWriter().write(objectMapper.writeValueAsString(new ExceptionResponse(e.getMessage())));
            } catch (IOException ioException) {
                log.error(ioException.getMessage());
            }
        }
    }
}
