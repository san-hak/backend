package com.mda.imirror.dto.response;

import com.mda.imirror.dto.checkup.BalanceDTO;
import com.mda.imirror.dto.checkup.RomDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CheckupResultResponse {
    private RomDTO rom;
    private BalanceDTO balance;
}
