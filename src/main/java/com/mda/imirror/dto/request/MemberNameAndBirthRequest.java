package com.mda.imirror.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberNameAndBirthRequest {
    private String name;
    private String birth;

    public LocalDate birthToLocalDate(String birth) {
        return LocalDate.parse(birth);
    }
}
