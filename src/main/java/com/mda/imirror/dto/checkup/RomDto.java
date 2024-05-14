package com.mda.imirror.dto.checkup;

import com.mda.imirror.domain.entity.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "가동범위")
@Getter
@Setter
public class RomDto {

    @Schema(description = "목 시상면 위로 올리는 최대 각도")
    private Double neckSagittalUp;

    @Schema(description = "목 시상면 아래로 내리는 최대 각도")
    private Double neckSagittalDown;

    @Schema(description = "목 이마면 왼쪽 굽히는 최대 각도")
    private Double neckFrontalLeft;

    @Schema(description = "목 이마면 오른쪽 굽히는 최대 각도")
    private Double neckFrontalRight;

    @Schema(description = "어깨 수평면 왼팔 위로 올리는 최대 각도")
    private Double shoulderHorizontalLeftUp;

    @Schema(description = "어깨 수평면 왼팔 아래로 내리는 최대 각도")
    private Double shoulderHorizontalLeftDown;

    @Schema(description = "어깨 수평면 오른팔 위로 올리는 최대 각도")
    private Double shoulderHorizontalRightUp;

    @Schema(description = "어깨 수평면 오른팔 아래로 내리는 최대 각도")
    private Double shoulderHorizontalRightDown;

    @Schema(description = "어깨 시상면 왼팔 위로 올리는 최대 각도")
    private Double shoulderSagittalLeftUp;

    @Schema(description = "어깨 시상면 왼팔 아래로 내리는 최대 각도")
    private Double shoulderSagittalLeftDown;

    @Schema(description = "어깨 시상면 오른팔 위로 올리는 최대 각도")
    private Double shoulderSagittalRightUp;

    @Schema(description = "어깨 시상면 오른팔 아래로 내리는 최대 각도")
    private Double shoulderSagittalRightDown;

    @Schema(description = "어깨 이마면 왼팔 위로 올리는 최대 각도")
    private Double shoulderFrontalLeftUp;

    @Schema(description = "어깨 이마면 왼팔 아래로 내리는 최대 각도")
    private Double shoulderFrontalLeftDown;

    @Schema(description = "어깨 이마면 오른팔 위로 올리는 최대 각도")
    private Double shoulderFrontalRightUp;

    @Schema(description = "어깨 이마면 오른팔 아래로 내리는 최대 각도")
    private Double shoulderFrontalRightDown;

    @Schema(description = "허리 시상면 뒤로 굽히는 최대 각도")
    private Double waistSagittalUp;

    @Schema(description = "허리 시상면 아래로 굽히는 최대 각도")
    private Double waistSagittalDown;

    @Schema(description = "허리 이마면 왼쪽 굽히는 최대 각도")
    private Double waistFrontalLeft;

    @Schema(description = "허리 이마면 오른쪽 굽히는 최대 각도")
    private Double waistFrontalRight;

    @Schema(description = "무릎 시상면 왼쪽 굽히는 최대 각도")
    private Double kneeSagittalLeft;

    @Schema(description = "무릎 시상면 오른쪽 굽히는 최대 각도")
    private Double kneeSagittalRight;


    @Schema(description = "프론트에서 보내지 말 것")
    private Member member;
}