package com.mda.imirror.service.impl;

import com.mda.imirror.domain.entity.Member;
import com.mda.imirror.dto.request.MemberChangeInfoRequest;
import com.mda.imirror.repository.MemberRepository;
import com.mda.imirror.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
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

    @Override
    public void changeMemberInfo(MemberChangeInfoRequest request) {
        Member byMemberId = memberRepository.findByMemberId("") //로그인 구현 후 수정 예정
                .orElseThrow(RuntimeException::new);

        Member member = Member.builder()
                //.memberId() 로그인 구현 후 정보 입력
                .memberName(request.getMemberName().isBlank() ? byMemberId.getMemberName() : request.getMemberName())
                .memberGender(request.getMemberGender() == null ? byMemberId.getMemberGender() : request.getMemberGender())
                .memberBirthDate(request.getMemberBirthDate() == null ? byMemberId.getMemberBirthDate() : request.getMemberBirthDate())
                .memberHeight(request.getMemberHeight() == null ? byMemberId.getMemberHeight() : request.getMemberHeight())
                .memberWeight(request.getMemberWeight() == null ? byMemberId.getMemberWeight() : request.getMemberWeight())
                .build();

        memberRepository.save(member);
    }

}
