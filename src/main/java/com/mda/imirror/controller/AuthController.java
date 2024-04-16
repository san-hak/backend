package com.mda.imirror.controller;

import com.mda.imirror.domain.request.MemberRegisterRequest;
import com.mda.imirror.domain.response.MemberRegisterResponse;
import com.mda.imirror.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MemberRegisterResponse> register(@RequestBody MemberRegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

}
