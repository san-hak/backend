package com.mda.imirror.dto.checkup;

import com.mda.imirror.domain.entity.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "균형")
@Getter
@Setter
public class BalanceDto {
    
    
    @Schema(description = "머리 이마면 각도 (음수 왼, 양수 오)")
    private Double headFrontalAngle;
    @Schema(description = "머리 시상면 각도 (음수 뒤, 양수 앞)")
    private Double headSagittalAngle;


    //어깨 각도
    @Schema(description = "어깨 왼쪽 각도")
    private Double shoulderLeftAngle;
    @Schema(description = "어깨 오른쪽 각도")
    private Double shoulderRightAngle;

    //라운드 숄더
    @Schema(description = "라운드 숄더 각도")
    private Double roundShoulderAngle;


    //골반 각도
    @Schema(description = "골반 왼쪽 각도")
    private Double pelvisLeftAngle;
    @Schema(description = "골반 오른쪽 각도")
    private Double pelvisRightAngle;


    //무릎 각도
    @Schema(description = "무릎 왼쪽 각도")
    private Double KneeLeftAngle;
    @Schema(description = "무릎 오른쪽 각도")
    private Double KneeRightAngle;


    //발목 각도
    @Schema(description = "발목 왼쪽 각도")
    private Double AnkleLeftAngle;
    @Schema(description = "발목 오른쪽 각도")
    private Double AnkleRightAngle;


    @Schema(description = "프론트에서 보내지 말 것")
    private Member member;

}