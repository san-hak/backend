package com.mda.imirror.dto.mapper.impl;

import com.mda.imirror.domain.entity.Balance;
import com.mda.imirror.domain.entity.Rom;
import com.mda.imirror.dto.checkup.BalanceDTO;
import com.mda.imirror.dto.checkup.RomDTO;
import com.mda.imirror.dto.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BalanceMapper extends EntityMapper<BalanceDTO, Balance> {
    BalanceMapper MAPPER = Mappers.getMapper(BalanceMapper.class);
}
