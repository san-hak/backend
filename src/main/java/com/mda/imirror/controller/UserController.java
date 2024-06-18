package com.mda.imirror.controller;

import com.mda.imirror.domain.entity.Member;
import com.mda.imirror.dto.mapper.impl.MemberMapper;
import com.mda.imirror.dto.request.MemberChangeInfoRequest;
import com.mda.imirror.dto.response.MemberInquiryResponse;
import com.mda.imirror.service.CheckupService;
import jakarta.validation.Valid;

import com.mda.imirror.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final MemberService memberService;
    private final CheckupService checkupService;

    @PutMapping
    public void changeMemberInfo(@RequestBody @Valid MemberChangeInfoRequest request, @AuthenticationPrincipal Member member) {
       memberService.changeMemberInfo(request, member);

    }

    @GetMapping
    public ResponseEntity<List<LocalDate>> getMember(@AuthenticationPrincipal Member member) {
        return ResponseEntity.ok().body(checkupService.getCheckupDates(member));
    }
}
