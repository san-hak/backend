package com.mda.imirror.dto.request;

import com.mda.imirror.dto.checkup.BalanceDTO;
import com.mda.imirror.dto.checkup.RomDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Schema(description = "회원 결과 등록 request")
@Getter
@Setter
public class CheckupResultRequest {
    @Schema(description = "이름", example = "홍길동")
    private String memberName;
    @Schema(description = "생년월일", example = "1997-05-04")
    private LocalDate memberBirthDate;

    @Schema(description = "가동범위")
    private RomDTO rom;
    @Schema(description = "균형")
    private BalanceDTO balance;
}
