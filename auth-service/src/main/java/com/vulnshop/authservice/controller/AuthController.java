package com.vulnshop.authservice.controller;

import com.vulnshop.authservice.dto.LoginRequest;
import com.vulnshop.authservice.dto.RegisterRequest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(
            @Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(
            @Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    // VULNERABILITY: exposes user info without auth check — IDOR setup
    @GetMapping("/user/{username}")
    public ResponseEntity<String> getUser(@PathVariable String username) {
        return ResponseEntity.ok("User: " + username);
    }
}