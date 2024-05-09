package com.mda.imirror.dto.checkup;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "가동범위")
@Getter
@Setter
public class RomDTO {
    @Schema(description = "시상면 위로 올리는 최대 각도")
    private Double sagittalNeckUpperAngle;

    @Schema(description = "시상면 아래로 내리는 최대 각도")
    private Double sagittalNeckLowerAngle;

    @Schema(description = "이마면 왼쪽 굽히는 최대 각도")
    private Double frontalNeckLeftAngle;

    @Schema(description = "이마면 오른쪽 굽히는 최대 각도")
    private Double frontalNeckRightAngle;

    @Schema(description = "수평면 왼팔 위로 올리는 최대 각도")
    private Double horizontalLeftArmUpperAngle;

    @Schema(description = "수평면 왼팔 아래로 올리는 최대 각도")
    private Double horizontalLeftArmLowerAngle;

    @Schema(description = "수평면 오른팔 위로 올리는 최대 각도")
    private Double horizontalRightArmUpperAngle;

    @Schema(description = "수평면 오른팔 아래로 올리는 최대 각도")
    private Double horizontalRightArmLowerAngle;

    @Schema(description = "시상면 왼팔 앞으로 올리는 최대 각도")
    private Double sagittalLeftArmFrontAngle;

    @Schema(description = "시상면 왼팔 뒤로 올리는 최대 각도")
    private Double sagittalLeftArmRearAngle;

    @Schema(description = "시상면 오른팔 앞으로 올리는 최대 각도")
    private Double sagittalRightArmFrontAngle;

    @Schema(description = "시상면 오른팔 뒤로 올리는 최대 각도")
    private Double sagittalRightArmRearAngle;

    @Schema(description = "이마면 왼팔 밖으로 올리는 최대 각도")
    private Double frontalLeftArmOuterAngle;

    @Schema(description = "이마면 왼팔 안으로 올리는 최대 각도")
    private Double frontalLeftArmInnerAngle;

    @Schema(description = "이마면 오른팔 밖으로 올리는 최대 각도")
    private Double frontalRightArmOuterAngle;

    @Schema(description = "이마면 오른팔 안으로 올리는 최대 각도")
    private Double frontalRightArmInnerAngle;

    @Schema(description = "시상면 뒤로 굽히는 최대 각도")
    private Double sagittalWaistRearAngle;

    @Schema(description = "시상면 앞으로 굽히는 최대 각도")
    private Double sagittalWaistFrontAngle;

    @Schema(description = "이마면 왼쪽으로 굽히는 최대 각도")
    private Double frontalWaistLeftAngle;

    @Schema(description = "이마면 오른쪽으로 굽히는 최대 각도")
    private Double frontalWaistRightAngle;

    @Schema(description = "왼쪽 무릎 뒤로 굽히는 최대 각도")
    private Double leftKneeRearAngle;

    @Schema(description = "오른쪽 무릎 뒤로 굽히는 최대 각도")
    private Double rightKneeRearAngle;
}