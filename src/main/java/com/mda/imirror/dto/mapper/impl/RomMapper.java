package com.mda.imirror.dto.mapper.impl;

import com.mda.imirror.domain.entity.Rom;
import com.mda.imirror.dto.checkup.RomDTO;
import com.mda.imirror.dto.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RomMapper extends EntityMapper<RomDTO, Rom> {
    RomMapper MAPPER = Mappers.getMapper(RomMapper.class);
}
