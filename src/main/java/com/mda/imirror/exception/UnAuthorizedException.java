package com.mda.imirror.exception;

import org.springframework.http.HttpStatus;

import java.io.Serial;

public class UnAuthorizedException extends CustomException {
    @Serial
    private static final long serialVersionUID = -6510401919582402295L;

    public UnAuthorizedException() {
        super(HttpStatus.UNAUTHORIZED, "로그인되지 않음");
    }
    public static final CustomException EXCEPTION = new UnAuthorizedException();
}
