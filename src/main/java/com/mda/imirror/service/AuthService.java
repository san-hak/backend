package com.mda.imirror.service;

import com.mda.imirror.domain.request.MemberRegisterRequest;
import com.mda.imirror.domain.response.MemberRegisterResponse;

public interface AuthService {
    MemberRegisterResponse register(MemberRegisterRequest request);
}
