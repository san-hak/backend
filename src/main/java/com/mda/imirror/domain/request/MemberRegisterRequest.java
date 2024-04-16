package com.mda.imirror.domain.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Getter
@Setter
public class MemberRegisterRequest {
    @NotBlank
    private String memberId;
    @NotBlank
    private String memberPassword;
    @NotBlank
    @Length(max = 100)
    private String memberName;
    @NotBlank
    private Boolean memberGender;
    @NotBlank
    @Length(max = 3)
    private Integer memberAge;
    private Double memberHeight;
    private Double memberWeight;
    @NotBlank
    private Boolean personalInfoConsent;
}
