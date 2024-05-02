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
    @Length(max = 100)
    private String memberName;
    @NotBlank
    private Boolean memberGender;
    @NotBlank
    @Length(max = 8)
    private LocalDate memberBirthDate;
    @NotBlank
    private Boolean personalInfoConsent;
}
