package com.mda.imirror.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Schema(description = "회원가입 request")
@Getter
@Setter
public class MemberRegisterRequest {
    @Schema(description = "이름", example = "홍길동")
    @NotBlank
    @Length(max = 100)
    private String memberName;
    @Schema(description = "성별")
    @NotBlank
    private Boolean isMale;
    @Schema(description = "생년월일", example = "1997-05-04")
    @NotBlank
    @Length(max = 8)
    private String memberBirthDate;
    @Schema(description = "개인정보사용동의서 동의 여부")
    @NotBlank
    private Boolean personalInfoConsent;
}
