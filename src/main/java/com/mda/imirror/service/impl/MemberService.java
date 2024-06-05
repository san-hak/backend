package com.mda.imirror.service.impl;

import com.mda.imirror.domain.entity.Member;
import com.mda.imirror.dto.mapper.impl.MemberMapper;
import com.mda.imirror.dto.request.MemberChangeInfoRequest;
import com.mda.imirror.dto.request.PageRequest;
import com.mda.imirror.dto.response.MemberInquiryResponse;
import com.mda.imirror.exception.MemberNotFoundException;
import com.mda.imirror.exception.UnAuthorizedException;
import com.mda.imirror.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class MemberService  {

    private final MemberRepository memberRepository;




    public MemberInquiryResponse findMemberByNameWithBirth(String name, String birth) {
        LocalDate localDate = LocalDate.parse(birth);
        return memberRepository.findByMemberNameAndMemberBirthDate(name, localDate).map(MemberMapper.MAPPER::toDto)
                .orElseThrow(MemberNotFoundException::new);
    }


    public Slice<MemberInquiryResponse> InquiryMembers() {
        PageRequest pageRequest = new PageRequest();
        Pageable pageable =  pageRequest.getPageable(Sort.by("memberName"));
        Slice<Member> members = memberRepository.findAllByOrderByMemberName(pageable);
        return members.map(MemberMapper.MAPPER::toDto);
    }


    @Transactional
    public void changeMemberInfo(MemberChangeInfoRequest request) {  //for admin
        Member member = memberRepository.findByMemberNameAndMemberBirthDate(request.getMemberName(), request.getMemberBirthDate())
                .orElseThrow(MemberNotFoundException::new);
        member.changeMemberInfo(
                request.getMemberName(),
                request.getMemberBirthDate(),
                request.getIsMale(),
                request.getPersonalInfoConsent(),
                null
        );
    }


    @Transactional
    public void changeMemberInfo(MemberChangeInfoRequest request, Member requester) {  //for user
        Member member = memberRepository.findByMemberNameAndMemberBirthDate(request.getMemberName(), request.getMemberBirthDate())
                .orElseThrow(MemberNotFoundException::new);
        if (!member.getMemberName().equals(requester.getMemberName())) {
            throw new UnAuthorizedException();
        }

        member.changeMemberInfo(
                request.getMemberName(),
                request.getMemberBirthDate(),
                request.getIsMale(),
                request.getPersonalInfoConsent(),
                null
        );
    }

}
