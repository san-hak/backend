package com.mda.imirror.dto.response;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
public class MemberInquiryResponse {
    private String memberName;
    private String memberGender;
    private LocalDate memberBirthDate;
    private Double memberHeight;
    private Double memberWeight;

}
