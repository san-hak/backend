package com.mda.imirror.exception;

import org.springframework.http.HttpStatus;

import java.io.Serial;

public class UnknownServerException extends CustomException{
    @Serial
    private static final long serialVersionUID = -6996068993616537399L;

    public UnknownServerException() {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "뭔가 잘못되었습니다.");
    }
}
