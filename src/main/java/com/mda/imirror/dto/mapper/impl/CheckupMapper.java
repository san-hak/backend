package com.mda.imirror.dto.mapper.impl;

import com.mda.imirror.domain.entity.Checkup;
import com.mda.imirror.dto.mapper.EntityMapper;
import com.mda.imirror.dto.response.CheckupResultResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CheckupMapper extends EntityMapper<CheckupResultResponse, Checkup> {

    CheckupMapper MAPPER = Mappers.getMapper(CheckupMapper.class);
}
