package com.mda.imirror.dto.request;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "로그인 request")
@Getter
@Setter
public class MemberLoginRequest {
    @Schema(description = "이름", example = "홍길동")
    @NotBlank(message = "이름을 입력해주세요.")
    private String memberName;

    @Schema(description = "생년월일", example = "1997-05-04")
    @NotBlank(message = "생년월일을 입력해주세요.")
    private String memberBirthDate;
}
