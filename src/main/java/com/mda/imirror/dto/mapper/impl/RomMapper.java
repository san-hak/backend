package com.mda.imirror.dto.mapper.impl;

import com.mda.imirror.domain.entity.Rom;
import com.mda.imirror.dto.checkup.RomDto;
import com.mda.imirror.dto.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RomMapper extends EntityMapper<RomDto, Rom> {

    RomMapper MAPPER = Mappers.getMapper(RomMapper.class);
}
