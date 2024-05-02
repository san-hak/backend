package com.mda.imirror.dto.checkup;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BalanceDTO {

    private String headTwisted;

    private String shoulderTwisted;

    private String pelvisTwisted;

    private String neckTwisted;

    private String shoulderRolled;

    private Double leftShoulderAngle;

    private Double rightShoulderAngle;

    private Double leftHipAngle;

    private Double rightHipAngle;

    private Double leftKneeAngle;

    private Double rightKneeAngle;

    private Double leftAnkleAngle;

    private Double rightAnkleAngle;

    private Double neckAngle;

    private Double waistAngle;
}
