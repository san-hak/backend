package com.mda.imirror.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
public class MemberChangeInfoRequest {
    @Length(max = 100)
    private String memberName;
    private LocalDate memberBirthDate;
    private Boolean memberGender;
}