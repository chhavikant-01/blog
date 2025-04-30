package com.nova.blog.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nova.blog.domain.dtos.AuthResponse;
import com.nova.blog.domain.dtos.LoginRequest;
import com.nova.blog.services.AuthenticationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping(path = "/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        UserDetails userDetails = authenticationService.authenticate(
                loginRequest.getEmail(),
                loginRequest.getPassword());
        String tokenValue = authenticationService.generateToken(userDetails);
        long expiresIn = 3600;
        return ResponseEntity.ok(AuthResponse
                .builder()
                .token(tokenValue)
                .expiresIn(expiresIn)
                .build());
    }

}
