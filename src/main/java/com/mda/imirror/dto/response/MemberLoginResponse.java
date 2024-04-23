package com.mda.imirror.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MemberLoginResponse {
    private String memberId;
    private String memberName;
    private Boolean memberGender;
    private Integer memberAge;
    private Double memberHeight;
    private Double memberWeight;
    private String role;

    private String sessionId;
}
