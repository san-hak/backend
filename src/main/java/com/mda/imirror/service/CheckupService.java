package com.mda.imirror.service;

import com.mda.imirror.domain.entity.Member;
import com.mda.imirror.dto.request.CheckupResultRequest;
import com.mda.imirror.dto.response.CheckupResultResponse;

import java.util.List;

public interface CheckupService {
    public void registerCheckupResult(CheckupResultRequest request);

    public List<CheckupResultResponse> getCheckupResult(Member member);
}
