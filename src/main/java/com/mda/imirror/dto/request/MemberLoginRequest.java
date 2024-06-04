package com.mda.imirror.dto.request;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "로그인 request")
@Getter
@Setter
public class MemberLoginRequest {
    @Schema(description = "이름", example = "홍길동")
    private String memberName;
    @Schema(description = "생년월일", example = "1997-05-04")
    private String memberBirthDate;
}
