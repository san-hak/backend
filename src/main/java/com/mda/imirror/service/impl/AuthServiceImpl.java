package com.mda.imirror.service.impl;

import com.mda.imirror.domain.Member;
import com.mda.imirror.domain.MemberRegisterRequest;
import com.mda.imirror.repository.MemberRepository;
import com.mda.imirror.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final MemberRepository memberRepository;

    @Override
    public Member register(MemberRegisterRequest request) {
        Member member = Member.builder()
                .memberName(request.getMemberName())
                .memberGender(request.getMemberGender())
                .memberAge(request.getMemberAge())
                .memberHeight(request.getMemberHeight())
                .memberWeight(request.getMemberWeight())
                .personalInfoConsent(request.getPersonalInfoConsent())
                .role(request.getRole())
                .build();

        memberRepository.save(member);
        return member;
    }

}
