package com.mda.imirror.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Schema(description = "결과 조회 response")
@Getter
@Setter
@AllArgsConstructor
public class CheckupResultResponse {

    @Schema(description = "목 시상면 위로 올리는 최대 각도")
    private Double sagittalNeckUpperAngle;

    @Schema(description = "목 시상면 아래로 내리는 최대 각도")
    private Double sagittalNeckLowerAngle;

    @Schema(description = "목 이마면 왼쪽 굽히는 최대 각도")
    private Double frontalNeckLeftAngle;

    @Schema(description = "목 이마면 오른쪽 굽히는 최대 각도")
    private Double frontalNeckRightAngle;

    @Schema(description = "어깨 수평면 왼팔 위로 올리는 최대 각도")
    private Double horizontalLeftArmUpperAngle;

    @Schema(description = "어깨 수평면 왼팔 아래로 내리는 최대 각도")
    private Double horizontalLeftArmLowerAngle;

    @Schema(description = "어깨 수평면 오른팔 위로 올리는 최대 각도")
    private Double horizontalRightArmUpperAngle;

    @Schema(description = "어깨 수평면 오른팔 아래로 내리는 최대 각도")
    private Double horizontalRightArmLowerAngle;

    @Schema(description = "어깨 시상면 왼팔 위로 올리는 최대 각도")
    private Double sagittalLeftArmFrontAngle;

    @Schema(description = "어깨 시상면 왼팔 아래로 내리는 최대 각도")
    private Double sagittalLeftArmRearAngle;

    @Schema(description = "어깨 시상면 오른팔 위로 올리는 최대 각도")
    private Double sagittalRightArmFrontAngle;

    @Schema(description = "어깨 시상면 오른팔 아래로 내리는 최대 각도")
    private Double sagittalRightArmRearAngle;

    @Schema(description = "어깨 이마면 왼팔 위로 올리는 최대 각도")
    private Double frontalLeftArmOuterAngle;

    @Schema(description = "어깨 이마면 왼팔 아래로 내리는 최대 각도")
    private Double frontalLeftArmInnerAngle;

    @Schema(description = "어깨 이마면 오른팔 위로 올리는 최대 각도")
    private Double frontalRightArmOuterAngle;

    @Schema(description = "어깨 이마면 오른팔 아래로 내리는 최대 각도")
    private Double frontalRightArmInnerAngle;

    @Schema(description = "허리 시상면 뒤로 굽히는 최대 각도")
    private Double sagittalWaistRearAngle;

    @Schema(description = "허리 시상면 아래로 굽히는 최대 각도")
    private Double sagittalWaistFrontAngle;

    @Schema(description = "허리 이마면 왼쪽 굽히는 최대 각도")
    private Double frontalWaistLeftAngle;

    @Schema(description = "허리 이마면 오른쪽 굽히는 최대 각도")
    private Double frontalWaistRightAngle;

    @Schema(description = "무릎 시상면 왼쪽 굽히는 최대 각도")
    private Double leftKneeRearAngle;

    @Schema(description = "무릎 시상면 오른쪽 굽히는 최대 각도")
    private Double rightKneeRearAngle;

    @Schema(description = "머리 이마면 각도 (음수 왼, 양수 오)")
    private Double headTwisted;
    @Schema(description = "머리 시상면 각도 (음수 뒤, 양수 앞)")
    private Double shoulderTwisted;

    private Double pelvisTwisted;

    private Double neckTwisted;

    private Double shoulderRolled;

    private LocalDate createdAt;

}
