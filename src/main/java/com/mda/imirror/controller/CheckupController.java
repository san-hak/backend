package com.mda.imirror.controller;

import com.mda.imirror.domain.entity.Member;
import com.mda.imirror.dto.request.CheckupResultRequest;
import com.mda.imirror.dto.response.CheckupResultResponse;
import com.mda.imirror.service.CheckupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/checkup")
@RequiredArgsConstructor
public class CheckupController {
    private final CheckupService checkupService;

    @PostMapping
    public void registerCheckupResult(@RequestBody CheckupResultRequest request) {
        checkupService.registerCheckupResult(request);
    }

    @GetMapping
    public ResponseEntity<List<CheckupResultResponse>> getCheckupResult(@AuthenticationPrincipal Member member) {

        return ResponseEntity.ok(checkupService.getCheckupResult(member));
    }
}
