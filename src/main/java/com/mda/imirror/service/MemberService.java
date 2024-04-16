package com.mda.imirror.service;

public interface MemberService {
    void changePassword(String originPassword, String changePassword, String memberId);
}
