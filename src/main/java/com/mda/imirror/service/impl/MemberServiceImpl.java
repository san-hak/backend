package com.mda.imirror.service.impl;

import com.mda.imirror.domain.entity.Member;
import com.mda.imirror.repository.MemberRepository;
import com.mda.imirror.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public void changePassword(String originPassword, String changePassword, String memberId) {
        Optional<Member> OptionalMember = memberRepository.findByMemberId(memberId);
        if(OptionalMember.isPresent()) {
            Member member = OptionalMember.get();
            member.changePassword(changePassword); //add passwordEncoder

        } else {
            throw new RuntimeException("USER NOT FOUND");
        }
    }
}
