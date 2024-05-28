package com.mda.imirror.exception;

import org.springframework.http.HttpStatus;

public class NotFoundUserException extends CustomException {
    public NotFoundUserException() {
        super(HttpStatus.NOT_FOUND, "존재하지 않는 유저");
    }
    public static final CustomException EXCEPTION = new NotFoundUserException();
}
