package com.mda.imirror.exception.controller;

import com.mda.imirror.exception.CustomException;
import com.mda.imirror.exception.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponse> exception(CustomException e) {
        return ResponseEntity
                .status(e.getStatus())
                .body(new ExceptionResponse(e.getMessage()));
    }

}
