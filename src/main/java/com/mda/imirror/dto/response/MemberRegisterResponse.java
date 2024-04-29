package com.mda.imirror.dto.response;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberRegisterResponse {
    private String memberId;
    private String memberName;

}
