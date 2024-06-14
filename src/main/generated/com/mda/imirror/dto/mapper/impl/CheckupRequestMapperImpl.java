package com.mda.imirror.dto.mapper.impl;

import com.mda.imirror.domain.entity.Checkup;
import com.mda.imirror.domain.entity.Checkup.CheckupBuilder;
import com.mda.imirror.dto.request.CheckupResultRequest;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-14T09:31:52+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.11 (JetBrains s.r.o.)"
)
public class CheckupRequestMapperImpl implements CheckupRequestMapper {

    @Override
    public CheckupResultRequest toDto(Checkup arg0) {
        if ( arg0 == null ) {
            return null;
        }

        CheckupResultRequest checkupResultRequest = new CheckupResultRequest();

        checkupResultRequest.setSagittalNeckUpperAngle( arg0.getSagittalNeckUpperAngle() );
        checkupResultRequest.setSagittalNeckLowerAngle( arg0.getSagittalNeckLowerAngle() );
        checkupResultRequest.setFrontalNeckLeftAngle( arg0.getFrontalNeckLeftAngle() );
        checkupResultRequest.setFrontalNeckRightAngle( arg0.getFrontalNeckRightAngle() );
        checkupResultRequest.setHorizontalLeftArmUpperAngle( arg0.getHorizontalLeftArmUpperAngle() );
        checkupResultRequest.setHorizontalLeftArmLowerAngle( arg0.getHorizontalLeftArmLowerAngle() );
        checkupResultRequest.setHorizontalRightArmUpperAngle( arg0.getHorizontalRightArmUpperAngle() );
        checkupResultRequest.setHorizontalRightArmLowerAngle( arg0.getHorizontalRightArmLowerAngle() );
        checkupResultRequest.setSagittalLeftArmFrontAngle( arg0.getSagittalLeftArmFrontAngle() );
        checkupResultRequest.setSagittalLeftArmRearAngle( arg0.getSagittalLeftArmRearAngle() );
        checkupResultRequest.setSagittalRightArmFrontAngle( arg0.getSagittalRightArmFrontAngle() );
        checkupResultRequest.setSagittalRightArmRearAngle( arg0.getSagittalRightArmRearAngle() );
        checkupResultRequest.setFrontalLeftArmOuterAngle( arg0.getFrontalLeftArmOuterAngle() );
        checkupResultRequest.setFrontalLeftArmInnerAngle( arg0.getFrontalLeftArmInnerAngle() );
        checkupResultRequest.setFrontalRightArmOuterAngle( arg0.getFrontalRightArmOuterAngle() );
        checkupResultRequest.setFrontalRightArmInnerAngle( arg0.getFrontalRightArmInnerAngle() );
        checkupResultRequest.setSagittalWaistRearAngle( arg0.getSagittalWaistRearAngle() );
        checkupResultRequest.setSagittalWaistFrontAngle( arg0.getSagittalWaistFrontAngle() );
        checkupResultRequest.setFrontalWaistLeftAngle( arg0.getFrontalWaistLeftAngle() );
        checkupResultRequest.setFrontalWaistRightAngle( arg0.getFrontalWaistRightAngle() );
        checkupResultRequest.setLeftKneeRearAngle( arg0.getLeftKneeRearAngle() );
        checkupResultRequest.setRightKneeRearAngle( arg0.getRightKneeRearAngle() );
        checkupResultRequest.setHeadTwisted( arg0.getHeadTwisted() );
        checkupResultRequest.setShoulderTwisted( arg0.getShoulderTwisted() );
        checkupResultRequest.setPelvisTwisted( arg0.getPelvisTwisted() );
        checkupResultRequest.setNeckTwisted( arg0.getNeckTwisted() );
        checkupResultRequest.setShoulderRolled( arg0.getShoulderRolled() );

        return checkupResultRequest;
    }

    @Override
    public Checkup toEntity(CheckupResultRequest arg0) {
        if ( arg0 == null ) {
            return null;
        }

        CheckupBuilder checkup = Checkup.builder();

        checkup.sagittalNeckUpperAngle( arg0.getSagittalNeckUpperAngle() );
        checkup.sagittalNeckLowerAngle( arg0.getSagittalNeckLowerAngle() );
        checkup.frontalNeckLeftAngle( arg0.getFrontalNeckLeftAngle() );
        checkup.frontalNeckRightAngle( arg0.getFrontalNeckRightAngle() );
        checkup.horizontalLeftArmUpperAngle( arg0.getHorizontalLeftArmUpperAngle() );
        checkup.horizontalLeftArmLowerAngle( arg0.getHorizontalLeftArmLowerAngle() );
        checkup.horizontalRightArmUpperAngle( arg0.getHorizontalRightArmUpperAngle() );
        checkup.horizontalRightArmLowerAngle( arg0.getHorizontalRightArmLowerAngle() );
        checkup.sagittalLeftArmFrontAngle( arg0.getSagittalLeftArmFrontAngle() );
        checkup.sagittalLeftArmRearAngle( arg0.getSagittalLeftArmRearAngle() );
        checkup.sagittalRightArmFrontAngle( arg0.getSagittalRightArmFrontAngle() );
        checkup.sagittalRightArmRearAngle( arg0.getSagittalRightArmRearAngle() );
        checkup.frontalLeftArmOuterAngle( arg0.getFrontalLeftArmOuterAngle() );
        checkup.frontalLeftArmInnerAngle( arg0.getFrontalLeftArmInnerAngle() );
        checkup.frontalRightArmOuterAngle( arg0.getFrontalRightArmOuterAngle() );
        checkup.frontalRightArmInnerAngle( arg0.getFrontalRightArmInnerAngle() );
        checkup.sagittalWaistRearAngle( arg0.getSagittalWaistRearAngle() );
        checkup.sagittalWaistFrontAngle( arg0.getSagittalWaistFrontAngle() );
        checkup.frontalWaistLeftAngle( arg0.getFrontalWaistLeftAngle() );
        checkup.frontalWaistRightAngle( arg0.getFrontalWaistRightAngle() );
        checkup.leftKneeRearAngle( arg0.getLeftKneeRearAngle() );
        checkup.rightKneeRearAngle( arg0.getRightKneeRearAngle() );
        checkup.headTwisted( arg0.getHeadTwisted() );
        checkup.shoulderTwisted( arg0.getShoulderTwisted() );
        checkup.pelvisTwisted( arg0.getPelvisTwisted() );
        checkup.neckTwisted( arg0.getNeckTwisted() );
        checkup.shoulderRolled( arg0.getShoulderRolled() );

        return checkup.build();
    }
}
