package com.nova.blog.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nova.blog.domain.dtos.ApiErrorResponse;
import com.nova.blog.domain.dtos.AuthResponse;
import com.nova.blog.domain.dtos.LoginRequest;
import com.nova.blog.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "api/v1/auth/login")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping
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
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidRequestFormat(HttpMessageNotReadableException ex) {
        log.error("Invalid login request format: {}", ex.getMessage());
        
        ApiErrorResponse error = ApiErrorResponse.builder()
            .status(HttpStatus.BAD_REQUEST.value())
            .message("Invalid login request format. Please provide valid email and password fields.")
            .build();
            
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
