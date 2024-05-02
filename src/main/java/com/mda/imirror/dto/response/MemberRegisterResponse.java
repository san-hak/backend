package com.mda.imirror.dto.response;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberRegisterResponse {
    private String memberName;
    private LocalDate memberBirthDate;

}
