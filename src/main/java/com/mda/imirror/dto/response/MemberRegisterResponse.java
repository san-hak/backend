package com.mda.imirror.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberRegisterResponse {
    private String memberName;
    private LocalDate memberBirthDate;

}
