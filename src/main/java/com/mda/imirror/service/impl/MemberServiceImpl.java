package com.mda.imirror.service.impl;

import com.mda.imirror.domain.entity.Member;
import com.mda.imirror.repository.MemberRepository;
import com.mda.imirror.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void changePassword(String originPassword, String changePassword, String memberId) {
        Optional<Member> OptionalMember = memberRepository.findByMemberId(memberId);
        if(OptionalMember.isPresent()) {
            Member member = OptionalMember.get();
            if(passwordEncoder.matches(originPassword, member.getMemberPassword())) {
                member.changePassword(passwordEncoder.encode(changePassword));
            } else {
                throw new RuntimeException("WRONG PASSWORD");
            }

        } else {
            throw new RuntimeException("USER NOT FOUND");
        }
    }
}
