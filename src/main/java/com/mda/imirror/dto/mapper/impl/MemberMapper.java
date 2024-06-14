package com.mda.imirror.dto.mapper.impl;

import com.mda.imirror.domain.entity.Member;
import com.mda.imirror.dto.mapper.EntityMapper;
import com.mda.imirror.dto.response.MemberInquiryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberMapper extends EntityMapper<MemberInquiryResponse, Member> {
    MemberMapper MAPPER = Mappers.getMapper(MemberMapper.class);

    @Override
    @Mapping(source = "recentCheckupDate", target = "recentTestDate")
    MemberInquiryResponse toDto(Member member);

    @Override
    Member toEntity(MemberInquiryResponse dto);
}
