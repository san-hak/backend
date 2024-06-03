package com.mda.imirror.exception;

import org.springframework.http.HttpStatus;

import java.io.Serial;

public class NotFoundUserException extends CustomException {
    @Serial
    private static final long serialVersionUID = 7766562078785538951L;

    public NotFoundUserException() {
        super(HttpStatus.NOT_FOUND, "존재하지 않는 유저");
    }
    public static final CustomException EXCEPTION = new NotFoundUserException();
}
