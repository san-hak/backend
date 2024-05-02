package com.mda.imirror.controller;

import com.mda.imirror.dto.request.MemberLoginRequest;
import com.mda.imirror.dto.request.MemberRegisterRequest;
import com.mda.imirror.dto.response.MemberLoginResponse;
import com.mda.imirror.dto.response.MemberRegisterResponse;
import com.mda.imirror.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
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
    public ResponseEntity<MemberRegisterResponse> register(@RequestBody MemberRegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MemberLoginResponse> login(@RequestBody MemberLoginRequest request) {
        return ResponseEntity.ok(authService.login(request));

    }

}
