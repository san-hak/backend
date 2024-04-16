package com.mda.imirror.service.impl;

import com.mda.imirror.domain.entity.Member;
import com.mda.imirror.domain.enums.MemberRole;
import com.mda.imirror.dto.request.MemberRegisterRequest;
import com.mda.imirror.dto.response.MemberRegisterResponse;
import com.mda.imirror.repository.MemberRepository;
import com.mda.imirror.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public MemberRegisterResponse register(MemberRegisterRequest request) {
        Member member = Member.builder()
                .memberId(request.getMemberId())
                .memberPassword(passwordEncoder.encode(request.getMemberPassword()))
                .memberName(request.getMemberName())
                .memberGender(request.getMemberGender())
                .memberAge(request.getMemberAge())
                .memberHeight(request.getMemberHeight())
                .memberWeight(request.getMemberWeight())
                .personalInfoConsent(request.getPersonalInfoConsent())
                .role(MemberRole.USER.toString())
                .build();

        memberRepository.save(member);
        return MemberRegisterResponse.builder().memberId(request.getMemberId()).memberName(request.getMemberName()).build();
    }

}
