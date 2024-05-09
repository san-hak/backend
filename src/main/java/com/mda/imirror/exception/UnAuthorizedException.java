package com.mda.imirror.exception;

import org.springframework.http.HttpStatus;

public class UnAuthorizedException extends CustomException {
    public UnAuthorizedException() {
        super(HttpStatus.UNAUTHORIZED, "로그인되지 않음");
    }
    public static final CustomException EXCEPTION = new UnAuthorizedException();
}
