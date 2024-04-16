package com.mda.imirror.service;

import com.mda.imirror.dto.request.MemberRegisterRequest;
import com.mda.imirror.dto.response.MemberRegisterResponse;

public interface AuthService {
    MemberRegisterResponse register(MemberRegisterRequest request);
}
