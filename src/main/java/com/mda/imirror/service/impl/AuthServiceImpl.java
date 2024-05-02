package com.mda.imirror.service.impl;

import com.mda.imirror.domain.entity.Member;
import com.mda.imirror.domain.enums.MemberRole;
import com.mda.imirror.dto.request.MemberLoginRequest;
import com.mda.imirror.dto.request.MemberRegisterRequest;
import com.mda.imirror.dto.response.MemberLoginResponse;
import com.mda.imirror.dto.response.MemberRegisterResponse;
import com.mda.imirror.repository.MemberRepository;
import com.mda.imirror.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final MemberRepository memberRepository;
//    private final PasswordEncoder passwordEncoder;

    @Override
    public MemberRegisterResponse register(MemberRegisterRequest request) {

        Member member = Member.builder()
                .memberName(request.getMemberName())
                .memberBirthDate(request.getMemberBirthDate())
                .memberGender(request.getMemberGender())
                .memberHeight(request.getMemberHeight())
                .memberWeight(request.getMemberWeight())
                .personalInfoConsent(request.getPersonalInfoConsent())
                .role(MemberRole.USER.toString())
                .build();

        memberRepository.save(member);
        return MemberRegisterResponse.builder()
                .memberName(request.getMemberName())
                .memberBirthDate(request.getMemberBirthDate())
                .build();
    }

    @Override
    public MemberLoginResponse login(MemberLoginRequest request) {
        Member member = memberRepository.findByMemberNameAndMemberBirthDate(request.getMemberName(), request.getMemberBirthDate())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));


        Authentication authentication = new UsernamePasswordAuthenticationToken(request.getMemberName(), request.getMemberBirthDate());
        SecurityContextHolder.getContext().setAuthentication(authentication);


        return MemberLoginResponse.builder()
                .memberName(member.getMemberName())
                .memberGender(member.getMemberGender())
                .memberBirthDate(member.getMemberBirthDate())
                .memberHeight(member.getMemberHeight())
                .memberWeight(member.getMemberWeight())
                .role(member.getRole())
                .build();
    }

    public void logout() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = servletRequestAttributes.getRequest().getSession();
        if(session != null) {
            session.invalidate();
        }
    }
}
