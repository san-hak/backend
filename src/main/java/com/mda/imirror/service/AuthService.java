package com.mda.imirror.service;

import com.mda.imirror.domain.Member;
import com.mda.imirror.domain.MemberRegisterRequest;

public interface AuthService {
    public Member register(MemberRegisterRequest request);
}
