package com.mda.imirror.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Schema(description = "회원 정보 변경 request")
@Getter
@Setter
public class MemberChangeInfoRequest {
    @Schema(description = "이름", example = "홍길동")
    @Length(max = 100, message = "이름은 100자 이하로 입력해주세요.")
    private String memberName;

    @Schema(description = "생년월일", example = "1997-05-04")
    private LocalDate memberBirthDate;

    @Schema(description = "성별")
    private Boolean isMale;

    @Schema(description = "개인정보 동의 여부")
    private Boolean personalInfoConsent;

}