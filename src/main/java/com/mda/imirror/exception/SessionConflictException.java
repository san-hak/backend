package com.mda.imirror.exception;

import org.springframework.http.HttpStatus;

import java.io.Serial;

public class SessionConflictException extends CustomException{
    @Serial
    private static final long serialVersionUID = 25677040205800450L;

    public SessionConflictException() {
        super(HttpStatus.CONFLICT, "로그아웃이 되지 않은 채, 로그인을 진행중입니다. 먼저 로그아웃을 해 주세요.");
    }
}
