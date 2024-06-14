package com.mda.imirror.service;
import com.mda.imirror.domain.entity.Member;
import com.mda.imirror.dto.mapper.impl.MemberMapper;
import com.mda.imirror.dto.request.MemberChangeInfoRequest;
import com.mda.imirror.dto.response.MemberInquiryResponse;
import com.mda.imirror.exception.MemberNotFoundException;
import com.mda.imirror.exception.UnAuthorizedException;
import com.mda.imirror.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberInquiryResponse findMemberByNameWithBirth(String name, String birth) {
        LocalDate localDate = LocalDate.parse(birth);
        return memberRepository.findByMemberNameAndMemberBirthDateAndRoleNot(name, localDate, "ROLE_ADMIN").map(MemberMapper.MAPPER::toDto)
                .orElseThrow(MemberNotFoundException::new);
    }

    public Slice<MemberInquiryResponse> findMemberByName(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page-1, size, Sort.by("memberName"));
        Slice<Member> members = memberRepository.findByMemberNameContainsAndRoleNotOrderByMemberBirthDateAsc(name, "ROLE_ADMIN",pageable);
        return members.map(MemberMapper.MAPPER::toDto);
    }


    public Slice<MemberInquiryResponse> InquiryMembers(int page, int size) {
        Pageable pageable = PageRequest.of(page-1, size, Sort.by("memberName"));
        Slice<Member> members = memberRepository.findByRoleNotOrderByMemberNameAscMemberBirthDateAsc("ROLE_ADMIN", pageable);
        return members.map(MemberMapper.MAPPER::toDto);
    }

    @Transactional
    public void changeMemberInfo(MemberChangeInfoRequest request, String name, String birth) {  //for admin
        LocalDate localDate = LocalDate.parse(birth);
        Member member = memberRepository.findByMemberNameAndMemberBirthDate(name, localDate)
                .orElseThrow(MemberNotFoundException::new);
        member.changeMemberInfo(
                request.getMemberName(),
                LocalDate.parse(request.getMemberBirthDate(), DateTimeFormatter.ISO_DATE),
                request.getIsMale(),
                request.getPersonalInfoConsent(),
                null
        );
    }

    @Transactional
    public void changeMemberInfo(MemberChangeInfoRequest request, Member requester) {  //for user
        Member member = memberRepository.findByMemberNameAndMemberBirthDate(request.getMemberName(), LocalDate.parse(request.getMemberBirthDate(), DateTimeFormatter.ISO_DATE))
                .orElseThrow(MemberNotFoundException::new);
        if (!member.getMemberName().equals(requester.getMemberName())) {
            throw new UnAuthorizedException();
        }

        member.changeMemberInfo(
                request.getMemberName(),
                LocalDate.parse(request.getMemberBirthDate(),DateTimeFormatter.ISO_DATE),
                request.getIsMale(),
                request.getPersonalInfoConsent(),
                null
        );
    }

}
