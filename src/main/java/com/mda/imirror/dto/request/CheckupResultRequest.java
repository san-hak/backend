package com.mda.imirror.dto.request;

import com.mda.imirror.dto.checkup.BalanceDTO;
import com.mda.imirror.dto.checkup.RomDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CheckupResultRequest {
    private String memberName;
    private LocalDate memberBirthDate;

    private RomDTO rom;
    private BalanceDTO balance;
}
