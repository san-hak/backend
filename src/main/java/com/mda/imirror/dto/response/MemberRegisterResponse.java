package com.mda.imirror.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

@Schema(description = "이름, 생년월일 등록 response")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberRegisterResponse {
    @Schema(description = "이름", example = "홍길동")
    private String memberName;

    @Schema(description = "생년월일", example = "1997-05-04")
    private LocalDate memberBirthDate;

}
