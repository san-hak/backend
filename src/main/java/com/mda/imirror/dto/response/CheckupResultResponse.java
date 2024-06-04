package com.mda.imirror.dto.response;

import com.mda.imirror.dto.checkup.BalanceDto;
import com.mda.imirror.dto.checkup.RomDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "결과 조회 response")
@Getter
@Setter
@AllArgsConstructor
public class CheckupResultResponse {
    @Schema(description = "가동범위")
    private RomDto rom;

    @Schema(description = "균형")
    private BalanceDto balance;
}
