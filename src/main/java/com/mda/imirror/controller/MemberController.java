package com.mda.imirror.controller;

import com.mda.imirror.domain.entity.Member;
import com.mda.imirror.dto.mapper.impl.MemberMapper;
import com.mda.imirror.dto.request.MemberChangeInfoRequest;
import com.mda.imirror.dto.response.MemberInquiryResponse;
import com.mda.imirror.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PutMapping
    public void changeMemberInfo(@RequestBody MemberChangeInfoRequest request, @AuthenticationPrincipal Member member) {
       memberService.changeMemberInfo(request, member);

    }

    @GetMapping
    public ResponseEntity<MemberInquiryResponse> getMember(@AuthenticationPrincipal Member member) {
        return ResponseEntity.ok().body(MemberMapper.MAPPER.toDto(member));
    }
}
