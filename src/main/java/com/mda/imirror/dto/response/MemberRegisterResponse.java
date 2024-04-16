package com.mda.imirror.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberRegisterResponse {
    private String memberId;
    private String memberName;

}
