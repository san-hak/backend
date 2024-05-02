package com.mda.imirror.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class MemberLoginRequest {
    private String memberName;
    private LocalDate memberBirthDate;
}
