package com.mda.imirror.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
public class CustomException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -2387600446270860884L;

    private final HttpStatus status;
    private final String message;

    public CustomException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
