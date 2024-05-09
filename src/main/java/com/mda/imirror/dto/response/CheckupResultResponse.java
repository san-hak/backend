package com.mda.imirror.dto.response;

import com.mda.imirror.dto.checkup.BalanceDTO;
import com.mda.imirror.dto.checkup.RomDTO;
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
    private RomDTO rom;
    @Schema(description = "균형")
    private BalanceDTO balance;
}
