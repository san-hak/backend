package com.mda.imirror.exception.controller;

import com.mda.imirror.exception.CustomException;
import com.mda.imirror.exception.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.format.DateTimeParseException;

@RestControllerAdvice
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponse> exception(CustomException e) {
        return ResponseEntity
                .status(e.getStatus())
                .body(new ExceptionResponse(e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> validationException(MethodArgumentNotValidException e) {
        return ResponseEntity
                .status(400)
                .body(new ExceptionResponse(
                        e.getBindingResult()
                                .getAllErrors()
                                .get(0)
                                .getDefaultMessage()
                ));
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<ExceptionResponse> dateTimeParseException(DateTimeParseException e) {
        return ResponseEntity
                .status(400)
                .body(new ExceptionResponse("날짜 형식이 올바르지 않습니다."
                ));
    }


}
