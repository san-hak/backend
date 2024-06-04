package com.mda.imirror.controller;

import com.mda.imirror.domain.entity.Member;
import com.mda.imirror.dto.request.CheckupResultRequest;
import com.mda.imirror.dto.request.MemberNameAndBirthRequest;
import com.mda.imirror.dto.response.CheckupResultResponse;
import com.mda.imirror.service.CheckupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "CheckUp", description = "결과 등록, 조회")
@RestController
@RequestMapping("/api/user/checkup")
@RequiredArgsConstructor
public class CheckupController {

    private final CheckupService checkupService;

    @Operation(description = "이름, 생년월일을 사용하여 결과 등록")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "등록 완료")
    })
    @PostMapping
    public void registerCheckupResult(@RequestBody CheckupResultRequest request) {
        checkupService.registerCheckupResult(request);
    }

    @Operation(description = "결과 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공")
    })
    @GetMapping
    public ResponseEntity<List<CheckupResultResponse>> getCheckupResult(@AuthenticationPrincipal Member member) {
        return ResponseEntity.ok(checkupService.getCheckupResult(member));
    }

    @GetMapping("/{name}/{birth}")
    public ResponseEntity<List<CheckupResultResponse>> getCheckupResult(@PathVariable String name, @PathVariable String birth) {
        return ResponseEntity.ok().body(checkupService.getCheckupResult(MemberNameAndBirthRequest.builder().name(name).birth(birth).build()));
    }

}
