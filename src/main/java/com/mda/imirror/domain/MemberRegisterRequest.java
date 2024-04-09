package com.mda.imirror.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Getter
@Setter
public class MemberRegisterRequest {
    @NotBlank
    @Length(max = 100)
    private String memberName;
    @NotBlank
    @Length(max = 1)
    private Boolean memberGender;
    @NotBlank
    @Length(max = 3)
    private Integer memberAge;
    @NotBlank
    private Double memberHeight;
    @NotBlank
    private Double memberWeight;
    @NotBlank
    @Length(max = 1)
    private Boolean personalInfoConsent;
    @NotBlank
    @Length(max = 10)
    private String role;

    private List<Rom> memberPkRoms;
    private List<Balance> memberPkBalances;
}
