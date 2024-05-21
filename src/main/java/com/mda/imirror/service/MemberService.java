package com.mda.imirror.service;

import com.mda.imirror.domain.entity.Member;
import com.mda.imirror.dto.request.MemberChangeInfoRequest;
import com.mda.imirror.dto.request.PageRequest;
import com.mda.imirror.dto.response.MemberInquiryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface MemberService {
    // 더 이상 ID와 비밀번호를 쓰기 않음
//    void changePassword(String originPassword, String changePassword, String memberId);
    MemberInquiryResponse findMemberByNameWithBirth(String name, String birth);
    Page<MemberInquiryResponse> InquiryMembers();
    void changeMemberInfo(MemberChangeInfoRequest request);
    void changeMemberInfo(MemberChangeInfoRequest request, Member requester);
}
