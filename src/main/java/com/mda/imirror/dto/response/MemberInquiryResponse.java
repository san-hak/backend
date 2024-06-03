package com.mda.imirror.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

@Schema(description = "회원 조회 Response")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberInquiryResponse {
    @Schema(description = "이름", example = "홍길동")
    private String memberName;

    @Schema(description = "성별")
    private String memberGender;

    @Schema(description = "생년월일", example = "1997-05-04")
    private LocalDate memberBirthDate;

    @Schema(description = "최근 검사일")
    private LocalDate recentTestDate;

}
