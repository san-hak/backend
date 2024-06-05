package com.mda.imirror.dto.mapper.impl;

import com.mda.imirror.dto.checkup.RomDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-28T18:16:14+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.11 (JetBrains s.r.o.)"
)
public class RomMapperImpl implements RomMapper {

    @Override
    public RomDto toDto(Rom entity) {
        if ( entity == null ) {
            return null;
        }

        RomDto romDto = new RomDto();

        romDto.setNeckSagittalUp( entity.getNeckSagittalUp() );
        romDto.setNeckSagittalDown( entity.getNeckSagittalDown() );
        romDto.setNeckFrontalLeft( entity.getNeckFrontalLeft() );
        romDto.setNeckFrontalRight( entity.getNeckFrontalRight() );
        romDto.setShoulderHorizontalLeftUp( entity.getShoulderHorizontalLeftUp() );
        romDto.setShoulderHorizontalLeftDown( entity.getShoulderHorizontalLeftDown() );
        romDto.setShoulderHorizontalRightUp( entity.getShoulderHorizontalRightUp() );
        romDto.setShoulderHorizontalRightDown( entity.getShoulderHorizontalRightDown() );
        romDto.setShoulderSagittalLeftUp( entity.getShoulderSagittalLeftUp() );
        romDto.setShoulderSagittalLeftDown( entity.getShoulderSagittalLeftDown() );
        romDto.setShoulderSagittalRightUp( entity.getShoulderSagittalRightUp() );
        romDto.setShoulderSagittalRightDown( entity.getShoulderSagittalRightDown() );
        romDto.setShoulderFrontalLeftUp( entity.getShoulderFrontalLeftUp() );
        romDto.setShoulderFrontalLeftDown( entity.getShoulderFrontalLeftDown() );
        romDto.setShoulderFrontalRightUp( entity.getShoulderFrontalRightUp() );
        romDto.setShoulderFrontalRightDown( entity.getShoulderFrontalRightDown() );
        romDto.setWaistSagittalUp( entity.getWaistSagittalUp() );
        romDto.setWaistSagittalDown( entity.getWaistSagittalDown() );
        romDto.setWaistFrontalLeft( entity.getWaistFrontalLeft() );
        romDto.setWaistFrontalRight( entity.getWaistFrontalRight() );
        romDto.setKneeSagittalLeft( entity.getKneeSagittalLeft() );
        romDto.setKneeSagittalRight( entity.getKneeSagittalRight() );
        romDto.setMember( entity.getMember() );

        return romDto;
    }

    @Override
    public Rom toEntity(RomDto dto) {
        if ( dto == null ) {
            return null;
        }

        RomBuilder rom = Rom.builder();

        rom.neckSagittalUp( dto.getNeckSagittalUp() );
        rom.neckSagittalDown( dto.getNeckSagittalDown() );
        rom.neckFrontalLeft( dto.getNeckFrontalLeft() );
        rom.neckFrontalRight( dto.getNeckFrontalRight() );
        rom.shoulderHorizontalLeftUp( dto.getShoulderHorizontalLeftUp() );
        rom.shoulderHorizontalLeftDown( dto.getShoulderHorizontalLeftDown() );
        rom.shoulderHorizontalRightUp( dto.getShoulderHorizontalRightUp() );
        rom.shoulderHorizontalRightDown( dto.getShoulderHorizontalRightDown() );
        rom.shoulderSagittalLeftUp( dto.getShoulderSagittalLeftUp() );
        rom.shoulderSagittalLeftDown( dto.getShoulderSagittalLeftDown() );
        rom.shoulderSagittalRightUp( dto.getShoulderSagittalRightUp() );
        rom.shoulderSagittalRightDown( dto.getShoulderSagittalRightDown() );
        rom.shoulderFrontalLeftUp( dto.getShoulderFrontalLeftUp() );
        rom.shoulderFrontalLeftDown( dto.getShoulderFrontalLeftDown() );
        rom.shoulderFrontalRightUp( dto.getShoulderFrontalRightUp() );
        rom.shoulderFrontalRightDown( dto.getShoulderFrontalRightDown() );
        rom.waistSagittalUp( dto.getWaistSagittalUp() );
        rom.waistSagittalDown( dto.getWaistSagittalDown() );
        rom.waistFrontalLeft( dto.getWaistFrontalLeft() );
        rom.waistFrontalRight( dto.getWaistFrontalRight() );
        rom.kneeSagittalLeft( dto.getKneeSagittalLeft() );
        rom.kneeSagittalRight( dto.getKneeSagittalRight() );
        rom.member( dto.getMember() );

        return rom.build();
    }
}
