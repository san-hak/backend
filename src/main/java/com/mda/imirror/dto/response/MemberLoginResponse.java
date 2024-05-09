package com.mda.imirror.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Schema(description = "로그인 Response")
@Builder
@Getter
@Setter
public class MemberLoginResponse {
    @Schema(description = "개인 아이디")
    private String memberId;
    @Schema(description = "이름", example = "홍길동")
    private String memberName;
    @Schema(description = "성별")
    private Boolean memberGender;
    @Schema(description = "생년월일", example = "1997-05-04")
    private LocalDate memberBirthDate;
    @Schema(description = "역할")
    private String role;

    @Schema(description = "세션 ID")
    private String sessionId;
}
