package com.mda.imirror.dto.mapper.impl;

import com.mda.imirror.domain.entity.Balance;
import com.mda.imirror.domain.entity.Balance.BalanceBuilder;
import com.mda.imirror.dto.checkup.BalanceDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-28T18:16:14+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.11 (JetBrains s.r.o.)"
)
public class BalanceMapperImpl implements BalanceMapper {

    @Override
    public BalanceDto toDto(Balance entity) {
        if ( entity == null ) {
            return null;
        }

        BalanceDto balanceDto = new BalanceDto();

        balanceDto.setHeadFrontalAngle( entity.getHeadFrontalAngle() );
        balanceDto.setHeadSagittalAngle( entity.getHeadSagittalAngle() );
        balanceDto.setShoulderLeftAngle( entity.getShoulderLeftAngle() );
        balanceDto.setShoulderRightAngle( entity.getShoulderRightAngle() );
        balanceDto.setRoundShoulderAngle( entity.getRoundShoulderAngle() );
        balanceDto.setPelvisLeftAngle( entity.getPelvisLeftAngle() );
        balanceDto.setPelvisRightAngle( entity.getPelvisRightAngle() );
        balanceDto.setKneeLeftAngle( entity.getKneeLeftAngle() );
        balanceDto.setKneeRightAngle( entity.getKneeRightAngle() );
        balanceDto.setAnkleLeftAngle( entity.getAnkleLeftAngle() );
        balanceDto.setAnkleRightAngle( entity.getAnkleRightAngle() );
        balanceDto.setMember( entity.getMember() );

        return balanceDto;
    }

    @Override
    public Balance toEntity(BalanceDto dto) {
        if ( dto == null ) {
            return null;
        }

        BalanceBuilder balance = Balance.builder();

        balance.headFrontalAngle( dto.getHeadFrontalAngle() );
        balance.headSagittalAngle( dto.getHeadSagittalAngle() );
        balance.shoulderLeftAngle( dto.getShoulderLeftAngle() );
        balance.shoulderRightAngle( dto.getShoulderRightAngle() );
        balance.roundShoulderAngle( dto.getRoundShoulderAngle() );
        balance.pelvisLeftAngle( dto.getPelvisLeftAngle() );
        balance.pelvisRightAngle( dto.getPelvisRightAngle() );
        balance.member( dto.getMember() );

        return balance.build();
    }
}
