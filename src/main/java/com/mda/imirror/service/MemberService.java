package com.mda.imirror.service;

import com.mda.imirror.dto.request.MemberChangeInfoRequest;

public interface MemberService {
    // 더 이상 ID와 비밀번호를 쓰기 않음
//    void changePassword(String originPassword, String changePassword, String memberId);
    void changeMemberInfo(MemberChangeInfoRequest request);
}
