package com.mda.imirror.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class MemberLoginResponse {
    private String memberId;
    private String memberName;
    private Boolean memberGender;
    private LocalDate memberBirthDate;
    private String role;

    private String sessionId;
}
