package com.mda.imirror.controller;

import com.mda.imirror.config.auth.PrincipalDetails;
import com.mda.imirror.domain.entity.Member;
import com.mda.imirror.dto.request.CheckupResultRequest;
import com.mda.imirror.dto.response.CheckupResultResponse;
import com.mda.imirror.service.CheckupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "CheckUp", description = "결과 등록, 조회")
@RestController
@RequestMapping("/api/user/checkup")
@RequiredArgsConstructor
@Slf4j
public class CheckupController {

    private final CheckupService checkupService;

    @Operation(description = "이름, 생년월일을 사용하여 결과 등록")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "등록 완료")
    })
    @PostMapping
    public void registerCheckupResult(@RequestBody @Valid CheckupResultRequest request) {
        checkupService.registerCheckupResult(request);
    }

    @Operation(description = "결과 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공")
    })
    @GetMapping
    public ResponseEntity<Slice<CheckupResultResponse>> getCheckupResult(
            @AuthenticationPrincipal Member member,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "1000-01-01") String startDate,
            @RequestParam(defaultValue = "3000-01-01") String endDate) {
        return ResponseEntity.ok(checkupService.getCheckupResult(member, page, size, startDate, endDate));
    }

}
