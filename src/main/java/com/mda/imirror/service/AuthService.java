package com.mda.imirror.service;

import com.mda.imirror.domain.entity.Member;
import com.mda.imirror.domain.enums.MemberRole;
import com.mda.imirror.dto.request.MemberLoginRequest;
import com.mda.imirror.dto.request.MemberRegisterRequest;
import com.mda.imirror.dto.response.MemberLoginResponse;
import com.mda.imirror.dto.response.MemberRegisterResponse;
import com.mda.imirror.exception.DuplicateMemberException;
import com.mda.imirror.exception.MemberNotFoundException;
import com.mda.imirror.exception.SessionConflictException;
import com.mda.imirror.exception.UnAuthorizedException;
import com.mda.imirror.repository.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;
    public MemberRegisterResponse register(MemberRegisterRequest request) {

        Member member = Member.builder()
                .memberName(request.getMemberName())
                .memberBirthDate(LocalDate.parse(request.getMemberBirthDate(), DateTimeFormatter.ISO_DATE))
                .isMale(request.getIsMale())
                .personalInfoConsent(request.getPersonalInfoConsent())
                .role(MemberRole.USER.toString())
                .build();

        if (memberRepository.findByMemberNameAndMemberBirthDate(request.getMemberName(), LocalDate.parse(request.getMemberBirthDate(), DateTimeFormatter.ISO_DATE)).isPresent()) {
            throw new DuplicateMemberException();
        }
        memberRepository.save(member);
        return MemberRegisterResponse.builder()
                .memberName(request.getMemberName())
                .memberBirthDate(LocalDate.parse(request.getMemberBirthDate(), DateTimeFormatter.ISO_DATE))
                .build();
    }

    public MemberLoginResponse login(MemberLoginRequest request, HttpServletRequest httpServletRequest) {

        HttpSession session = httpServletRequest.getSession(true);

        Member member = memberRepository.findByMemberNameAndMemberBirthDate(request.getMemberName(), LocalDate.parse(request.getMemberBirthDate(), DateTimeFormatter.ISO_DATE))
                .orElseThrow(MemberNotFoundException::new);
        if (session.getAttribute("member")!=member && session.getAttribute("member")!=null) {
            session.invalidate();
            throw new SessionConflictException();
        }

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
