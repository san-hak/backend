package com.mda.imirror.dto.mapper.impl;

import com.mda.imirror.domain.entity.Checkup;
import com.mda.imirror.domain.entity.Checkup.CheckupBuilder;
import com.mda.imirror.dto.response.CheckupResultResponse;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-14T09:31:52+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.11 (JetBrains s.r.o.)"
)
public class CheckupMapperImpl implements CheckupMapper {

    @Override
    public CheckupResultResponse toDto(Checkup arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Double sagittalNeckUpperAngle = null;
        Double sagittalNeckLowerAngle = null;
        Double frontalNeckLeftAngle = null;
        Double frontalNeckRightAngle = null;
        Double horizontalLeftArmUpperAngle = null;
        Double horizontalLeftArmLowerAngle = null;
        Double horizontalRightArmUpperAngle = null;
        Double horizontalRightArmLowerAngle = null;
        Double sagittalLeftArmFrontAngle = null;
        Double sagittalLeftArmRearAngle = null;
        Double sagittalRightArmFrontAngle = null;
        Double sagittalRightArmRearAngle = null;
        Double frontalLeftArmOuterAngle = null;
        Double frontalLeftArmInnerAngle = null;
        Double frontalRightArmOuterAngle = null;
        Double frontalRightArmInnerAngle = null;
        Double sagittalWaistRearAngle = null;
        Double sagittalWaistFrontAngle = null;
        Double frontalWaistLeftAngle = null;
        Double frontalWaistRightAngle = null;
        Double leftKneeRearAngle = null;
        Double rightKneeRearAngle = null;
        Double headTwisted = null;
        Double shoulderTwisted = null;
        Double pelvisTwisted = null;
        Double neckTwisted = null;
        Double shoulderRolled = null;

        sagittalNeckUpperAngle = arg0.getSagittalNeckUpperAngle();
        sagittalNeckLowerAngle = arg0.getSagittalNeckLowerAngle();
        frontalNeckLeftAngle = arg0.getFrontalNeckLeftAngle();
        frontalNeckRightAngle = arg0.getFrontalNeckRightAngle();
        horizontalLeftArmUpperAngle = arg0.getHorizontalLeftArmUpperAngle();
        horizontalLeftArmLowerAngle = arg0.getHorizontalLeftArmLowerAngle();
        horizontalRightArmUpperAngle = arg0.getHorizontalRightArmUpperAngle();
        horizontalRightArmLowerAngle = arg0.getHorizontalRightArmLowerAngle();
        sagittalLeftArmFrontAngle = arg0.getSagittalLeftArmFrontAngle();
        sagittalLeftArmRearAngle = arg0.getSagittalLeftArmRearAngle();
        sagittalRightArmFrontAngle = arg0.getSagittalRightArmFrontAngle();
        sagittalRightArmRearAngle = arg0.getSagittalRightArmRearAngle();
        frontalLeftArmOuterAngle = arg0.getFrontalLeftArmOuterAngle();
        frontalLeftArmInnerAngle = arg0.getFrontalLeftArmInnerAngle();
        frontalRightArmOuterAngle = arg0.getFrontalRightArmOuterAngle();
        frontalRightArmInnerAngle = arg0.getFrontalRightArmInnerAngle();
        sagittalWaistRearAngle = arg0.getSagittalWaistRearAngle();
        sagittalWaistFrontAngle = arg0.getSagittalWaistFrontAngle();
        frontalWaistLeftAngle = arg0.getFrontalWaistLeftAngle();
        frontalWaistRightAngle = arg0.getFrontalWaistRightAngle();
        leftKneeRearAngle = arg0.getLeftKneeRearAngle();
        rightKneeRearAngle = arg0.getRightKneeRearAngle();
        headTwisted = arg0.getHeadTwisted();
        shoulderTwisted = arg0.getShoulderTwisted();
        pelvisTwisted = arg0.getPelvisTwisted();
        neckTwisted = arg0.getNeckTwisted();
        shoulderRolled = arg0.getShoulderRolled();

        CheckupResultResponse checkupResultResponse = new CheckupResultResponse( sagittalNeckUpperAngle, sagittalNeckLowerAngle, frontalNeckLeftAngle, frontalNeckRightAngle, horizontalLeftArmUpperAngle, horizontalLeftArmLowerAngle, horizontalRightArmUpperAngle, horizontalRightArmLowerAngle, sagittalLeftArmFrontAngle, sagittalLeftArmRearAngle, sagittalRightArmFrontAngle, sagittalRightArmRearAngle, frontalLeftArmOuterAngle, frontalLeftArmInnerAngle, frontalRightArmOuterAngle, frontalRightArmInnerAngle, sagittalWaistRearAngle, sagittalWaistFrontAngle, frontalWaistLeftAngle, frontalWaistRightAngle, leftKneeRearAngle, rightKneeRearAngle, headTwisted, shoulderTwisted, pelvisTwisted, neckTwisted, shoulderRolled );

        return checkupResultResponse;
    }

    @Override
    public Checkup toEntity(CheckupResultResponse arg0) {
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
