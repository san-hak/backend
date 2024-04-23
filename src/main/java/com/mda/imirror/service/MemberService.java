package com.mda.imirror.service;

import com.mda.imirror.dto.request.MemberChangeInfoRequest;

public interface MemberService {
    void changePassword(String originPassword, String changePassword, String memberId);
    void changeMemberInfo(MemberChangeInfoRequest request);
}
