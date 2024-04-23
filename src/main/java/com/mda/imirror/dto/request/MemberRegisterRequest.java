package com.mda.imirror.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

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
    @Length(max = 8)
    private LocalDate memberBirthDate;
    private Double memberHeight;
    private Double memberWeight;
    @NotBlank
    private Boolean personalInfoConsent;
}
