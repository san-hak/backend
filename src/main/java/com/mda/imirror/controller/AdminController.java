package com.mda.imirror.controller;

import com.mda.imirror.dto.request.MemberChangeInfoRequest;
import com.mda.imirror.dto.request.PageRequest;
import com.mda.imirror.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final MemberService memberService;

    @GetMapping("/{name}/{birth}")
    public ResponseEntity getMember(@PathVariable String name, @PathVariable String birth) {
        return ResponseEntity.ok(memberService.findMemberByNameWithBirth(name, birth));
    }

    @GetMapping
    public ResponseEntity getMembers(@RequestBody PageRequest request) {
        return ResponseEntity.ok(memberService.InquiryMembers(request));
    }

    @PutMapping
    public void modifyMemberInfo(@RequestBody MemberChangeInfoRequest request) {
        memberService.changeMemberInfo(request);
    }
}
