package com.mda.imirror.controller;

import com.mda.imirror.dto.request.MemberChangeInfoRequest;
import com.mda.imirror.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;

@RestController("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final MemberService memberService;

    @PutMapping
    public void modifyMemberInfo(@RequestBody MemberChangeInfoRequest request) {
        memberService.changeMemberInfo(request);
    }
}
