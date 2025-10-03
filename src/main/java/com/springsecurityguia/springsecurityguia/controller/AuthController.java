package com.springsecurityguia.springsecurityguia.controller;

import com.springsecurityguia.springsecurityguia.dto.AuthDTO;
import com.springsecurityguia.springsecurityguia.dto.RegisterUserRequestDTO;
import com.springsecurityguia.springsecurityguia.entity.UserEntity;
import com.springsecurityguia.springsecurityguia.service.AuthService;
import com.springsecurityguia.springsecurityguia.service.RegisterUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final RegisterUserService registerUserService;
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Object> auth(@RequestBody AuthDTO authDTO){
        Object response = authService.login(authDTO);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody RegisterUserRequestDTO request){
        UserEntity response = registerUserService.registerUser(request);
        return ResponseEntity.ok().body(response);
    }
}
