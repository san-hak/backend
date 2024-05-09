package com.mda.imirror.dto.checkup;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "균형")
@Getter
@Setter
public class BalanceDTO {
    @Schema(description = "고개 틀어짐 여부")
    private String headTwisted;

    @Schema(description = "어깨 틀어짐 여부")
    private String shoulderTwisted;

    @Schema(description = "골반 틀어짐 여부")
    private String pelvisTwisted;

    @Schema(description = "목 틀어짐 여부")
    private String neckTwisted;

    @Schema(description = "어깨 말림 여부")
    private String shoulderRolled;

    @Schema(description = "왼쪽 어깨 틀어진 각도")
    private Double leftShoulderAngle;

    @Schema(description = "오른쪽 어깨 틀어진 각도")
    private Double rightShoulderAngle;

    @Schema(description = "왼쪽 엉덩이 틀어진 각도")
    private Double leftHipAngle;

    @Schema(description = "오른쪽 엉덩이 틀어진 각도")
    private Double rightHipAngle;

    @Schema(description = "왼쪽 무릎 틀어진 각도")
    private Double leftKneeAngle;

    @Schema(description = "오른쪽 무릎 틀어진 각도")
    private Double rightKneeAngle;

    @Schema(description = "왼쪽 발목 틀어진 각도")
    private Double leftAnkleAngle;

    @Schema(description = "오른쪽 발목 틀어진 각도")
    private Double rightAnkleAngle;

    @Schema(description = "목 틀어진 각도")
    private Double neckAngle;

    @Schema(description = "허리 틀어진 각도")
    private Double waistAngle;

}