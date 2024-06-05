package com.mda.imirror.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Schema(description = "회원가입 request")
@Getter
@Setter
public class MemberRegisterRequest {
    @Schema(description = "이름", example = "홍길동")
    @NotBlank(message = "이름을 입력해주세요.")
    @Length(max = 100, message = "이름은 100자 이하로 입력해주세요.")
    private String memberName;

    @Schema(description = "성별")
    @NotNull(message = "성별을 입력해주세요.")
    private Boolean isMale;

    @Schema(description = "생년월일", example = "1997-05-04")
    @NotBlank(message = "생년월일을 입력해주세요.")
    private String memberBirthDate;


    @Schema(description = "개인정보사용동의서 동의 여부")
    @NotNull(message = "개인정보사용동의서 동의 여부를 입력해주세요.")
    private Boolean personalInfoConsent;
}
