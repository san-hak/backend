package com.mda.imirror.service.impl;

import com.mda.imirror.domain.entity.Member;
import com.mda.imirror.domain.enums.MemberRole;
import com.mda.imirror.dto.request.MemberLoginRequest;
import com.mda.imirror.dto.request.MemberRegisterRequest;
import com.mda.imirror.dto.response.MemberLoginResponse;
import com.mda.imirror.dto.response.MemberRegisterResponse;
import com.mda.imirror.exception.DuplicateMemberException;
import com.mda.imirror.exception.MemberNotFoundException;
import com.mda.imirror.exception.UnAuthorizedException;
import com.mda.imirror.repository.MemberRepository;
import com.mda.imirror.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final MemberRepository memberRepository;
    @Override
    public MemberRegisterResponse register(MemberRegisterRequest request) {

        Member member = Member.builder()
                .memberName(request.getMemberName())
                .memberBirthDate(request.getMemberBirthDate())
                .isMale(request.getIsMale())
                .personalInfoConsent(request.getPersonalInfoConsent())
                .role(MemberRole.USER.toString())
                .build();

        if (memberRepository.existsByMemberNameAndMemberBirthDate(request.getMemberName(), request.getMemberBirthDate())) {
            throw new DuplicateMemberException();
        }
        memberRepository.save(member);
        return MemberRegisterResponse.builder()
                .memberName(request.getMemberName())
                .memberBirthDate(request.getMemberBirthDate())
                .build();
    }

    @Override
    public MemberLoginResponse login(MemberLoginRequest request, HttpServletRequest httpServletRequest) {
        Member member = memberRepository.findByMemberNameAndMemberBirthDate(request.getMemberName(), request.getMemberBirthDate())
                .orElseThrow(MemberNotFoundException::new);

        HttpSession session = httpServletRequest.getSession(true);
        session.setAttribute("member", member);


        return MemberLoginResponse.builder()
                .memberName(member.getMemberName())
                .memberGender(member.getIsMale())
                .memberBirthDate(member.getMemberBirthDate())
                .role(member.getRole())
                .build();
    }

    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        } else {
            throw new UnAuthorizedException();
        }
    }
}
