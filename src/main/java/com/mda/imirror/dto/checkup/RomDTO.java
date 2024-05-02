package com.mda.imirror.dto.checkup;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RomDTO {
    private Double sagittalNeckUpperAngle;

    private Double sagittalNeckLowerAngle;

    private Double frontalNeckLeftAngle;

    private Double frontalNeckRightAngle;

    private Double horizontalLeftArmUpperAngle;

    private Double horizontalLeftArmLowerAngle;

    private Double horizontalRightArmUpperAngle;

    private Double horizontalRightArmLowerAngle;

    private Double sagittalLeftArmFrontAngle;

    private Double sagittalLeftArmRearAngle;

    private Double sagittalRightArmFrontAngle;

    private Double sagittalRightArmRearAngle;

    private Double frontalLeftArmOuterAngle;

    private Double frontalLeftArmInnerAngle;

    private Double frontalRightArmOuterAngle;

    private Double frontalRightArmInnerAngle;

    private Double sagittalWaistRearAngle;

    private Double sagittalWaistFrontAngle;

    private Double frontalWaistLeftAngle;

    private Double frontalWaistRightAngle;

    private Double leftKneeRearAngle;

    private Double rightKneeRearAngle;
}
