package com.mda.imirror.dto.mapper.impl;

import com.mda.imirror.domain.entity.Member;
import com.mda.imirror.domain.entity.Member.MemberBuilder;
import com.mda.imirror.dto.response.MemberInquiryResponse;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-28T18:16:14+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.11 (JetBrains s.r.o.)"
)
public class MemberMapperImpl implements MemberMapper {

    @Override
    public MemberInquiryResponse toDto(Member entity) {
        if ( entity == null ) {
            return null;
        }

        MemberInquiryResponse memberInquiryResponse = new MemberInquiryResponse();

        memberInquiryResponse.setMemberName( entity.getMemberName() );
        memberInquiryResponse.setMemberBirthDate( entity.getMemberBirthDate() );

        return memberInquiryResponse;
    }

    @Override
    public Member toEntity(MemberInquiryResponse dto) {
        if ( dto == null ) {
            return null;
        }

        MemberBuilder member = Member.builder();

        member.memberName( dto.getMemberName() );
        member.memberBirthDate( dto.getMemberBirthDate() );

        return member.build();
    }
}
