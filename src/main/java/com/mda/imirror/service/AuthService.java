package com.mda.imirror.service;

import com.mda.imirror.dto.request.MemberLoginRequest;
import com.mda.imirror.dto.request.MemberRegisterRequest;
import com.mda.imirror.dto.response.MemberLoginResponse;
import com.mda.imirror.dto.response.MemberRegisterResponse;
import jakarta.servlet.http.HttpServletRequest;

public interface AuthService {
    MemberRegisterResponse register(MemberRegisterRequest request);

    MemberLoginResponse login(MemberLoginRequest request);
}
