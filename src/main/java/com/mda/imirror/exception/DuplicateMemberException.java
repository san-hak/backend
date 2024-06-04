package com.mda.imirror.exception;

import org.springframework.http.HttpStatus;

import java.io.Serial;

public class DuplicateMemberException extends CustomException{
    @Serial
    private static final long serialVersionUID = 8699793627649266027L;

    public DuplicateMemberException() {
        super(HttpStatus.CONFLICT, "중복 회원입니다");
    }

    public static final CustomException EXCEPTION = new UnAuthorizedException();

}
