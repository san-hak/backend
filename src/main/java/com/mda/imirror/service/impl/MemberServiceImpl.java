package com.mda.imirror.service.impl;

import com.mda.imirror.domain.entity.Member;
import com.mda.imirror.dto.mapper.impl.MemberMapper;
import com.mda.imirror.dto.request.MemberChangeInfoRequest;
import com.mda.imirror.dto.request.PageRequest;
import com.mda.imirror.dto.response.MemberInquiryResponse;
import com.mda.imirror.exception.NotFoundUserException;
import com.mda.imirror.exception.UnAuthorizedException;
import com.mda.imirror.repository.MemberRepository;
import com.mda.imirror.service.MemberService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    // 더 이상 ID와 비밀번호를 쓰기 않음
//    @Override
//    public void changePassword(String originPassword, String changePassword, String memberId) {
//        Optional<Member> OptionalMember = memberRepository.findByMemberId(memberId);
//        if(OptionalMember.isPresent()) {
//            Member member = OptionalMember.get();
//            if(passwordEncoder.matches(originPassword, member.getMemberPassword())) {
//                member.changePassword(passwordEncoder.encode(changePassword));
//            } else {
//                throw new RuntimeException("WRONG PASSWORD");
//            }
//
//        } else {
//            throw new NotFoundUserException;
//        }
//    }


    @Override
    public MemberInquiryResponse findMemberByNameWithBirth(String name, String birth) {
        LocalDate localDate = LocalDate.parse(birth);
        return memberRepository.findByMemberNameAndMemberBirthDate(name, localDate).map(MemberMapper.MAPPER::toDto)
                .orElseThrow(NotFoundUserException::new);
    }

    @Override
    public Page<MemberInquiryResponse> InquiryMembers(PageRequest request) {
        Pageable pageable = request.getPageable(Sort.by("memberName"));
        Page<Member> members = memberRepository.findAll(pageable);
        return members.map(MemberMapper.MAPPER::toDto);
    }

    @Override
    @Transactional
    public void changeMemberInfo(MemberChangeInfoRequest request) {  //for admin
        Member member = memberRepository.findByMemberNameAndMemberBirthDate(request.getMemberName(), request.getMemberBirthDate())
                .orElseThrow(NotFoundUserException::new);
        member.changeMemberInfo(
                request.getMemberName(),
                request.getMemberBirthDate(),
                request.getIsMale());
    }

    @Override
    @Transactional
    public void changeMemberInfo(MemberChangeInfoRequest request, Member requester) {  //for user
        Member member = memberRepository.findByMemberNameAndMemberBirthDate(request.getMemberName(), request.getMemberBirthDate())
                .orElseThrow(NotFoundUserException::new);
        if (!member.getMemberName().equals(requester.getMemberName())) {
            throw new UnAuthorizedException();
        }

        member.changeMemberInfo(
                request.getMemberName(),
                request.getMemberBirthDate(),
                request.getIsMale());
    }

}
