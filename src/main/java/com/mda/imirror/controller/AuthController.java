package com.mda.imirror.controller;

import com.mda.imirror.domain.Member;
import com.mda.imirror.domain.MemberRegisterRequest;
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
    public ResponseEntity register(@RequestBody MemberRegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

}
