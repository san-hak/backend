package com.mda.imirror.dto.mapper.impl;

import com.mda.imirror.domain.entity.Member;
import com.mda.imirror.domain.entity.Member.MemberBuilder;
import com.mda.imirror.dto.response.MemberInquiryResponse;
import com.mda.imirror.dto.response.MemberInquiryResponse.MemberInquiryResponseBuilder;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-14T10:35:25+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.11 (JetBrains s.r.o.)"
)
public class MemberMapperImpl implements MemberMapper {

    @Override
    public MemberInquiryResponse toDto(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberInquiryResponseBuilder memberInquiryResponse = MemberInquiryResponse.builder();

        memberInquiryResponse.recentTestDate( member.getRecentCheckupDate() );
        memberInquiryResponse.memberName( member.getMemberName() );
        memberInquiryResponse.isMale( member.getIsMale() );
        memberInquiryResponse.memberBirthDate( member.getMemberBirthDate() );

        return memberInquiryResponse.build();
    }

    @Override
    public Member toEntity(MemberInquiryResponse dto) {
        if ( dto == null ) {
            return null;
        }

        MemberBuilder member = Member.builder();

        member.memberName( dto.getMemberName() );
        member.isMale( dto.getIsMale() );
        member.memberBirthDate( dto.getMemberBirthDate() );

        return member.build();
    }
}
