package com.mda.imirror.controller;

import com.mda.imirror.dto.request.MemberChangeInfoRequest;
import com.mda.imirror.dto.request.PageRequest;
import com.mda.imirror.dto.response.CheckupResultResponse;
import com.mda.imirror.dto.response.MemberInquiryResponse;
import com.mda.imirror.service.CheckupService;
import com.mda.imirror.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Admin", description = "관리자")
@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final MemberService memberService;
    private final CheckupService checkupService;

    @Operation(summary = "회원 단일 조회", description = "Path에 name, birth 필요")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "404", description = "해당 유저가 존재하지 않음")
    })
    @GetMapping("/{name}/{birth}")
    public ResponseEntity<MemberInquiryResponse> getMember(@Parameter(name = "name", description = "이름") @PathVariable String name,
                                                           @Parameter(name = "birth", description = "생년월일") @PathVariable String birth) {
        return ResponseEntity.ok().body(memberService.findMemberByNameWithBirth(name, birth));
    }


    @Operation(summary = "회원 검색", description = "Path에 name 필요")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공")
    })
    @GetMapping("/{name}")
    public ResponseEntity<Slice<MemberInquiryResponse>> getMember(
            @Parameter(name = "name", description = "이름") @PathVariable String name,
            @Parameter(name = "page", description = "페이지") @RequestParam(defaultValue = "1") int page,
            @Parameter(name = "size", description = "페이지당 결과 개수") @RequestParam(defaultValue = "20") int size) {
        return ResponseEntity.ok().body(memberService.findMemberByName(name, page, size));
    }


    @Operation(summary = "회원 전체 조회")
    @ApiResponse(responseCode = "200", description = "조회 성공")
    @GetMapping("")
    public ResponseEntity<Slice<MemberInquiryResponse>> getMembers(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        return ResponseEntity.ok().body(memberService.InquiryMembers(page, size));
    }

    @Operation(summary = "회원 정보 변경", description = "이름, 생년월일, 성별 변경 가능")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "변경 성공"),
            @ApiResponse(responseCode = "405", description = "잘못된 메서드"),
            @ApiResponse(responseCode = "415", description = "잘못된 타입")
    })
    @PutMapping("/{name}/{birth}")
    public void modifyMemberInfo(
            @RequestBody MemberChangeInfoRequest request,
            @Parameter(name = "name", description = "이름") @PathVariable String name,
            @Parameter(name = "birth", description = "생년월일") @PathVariable String birth) {
        memberService.changeMemberInfo(request, name, birth);
    }

    @Operation(summary = "회원 검사 이력 조회")
    @ApiResponse(responseCode = "200", description = "조회 성공")
    @GetMapping("checkup/{name}/{birth}")
    public ResponseEntity<List<CheckupResultResponse>> getUserCheckupResult(@PathVariable String name, @PathVariable String birth) {
        return ResponseEntity.ok().body(checkupService.getCheckupResult(name, birth));
    }
}
