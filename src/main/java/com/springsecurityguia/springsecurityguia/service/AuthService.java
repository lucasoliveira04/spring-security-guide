package com.springsecurityguia.springsecurityguia.service;

import com.springsecurityguia.springsecurityguia.dto.AuthDTO;
import com.springsecurityguia.springsecurityguia.entity.UserEntity;
import com.springsecurityguia.springsecurityguia.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenService jwtTokenService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenService jwtTokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenService = jwtTokenService;
    }

    public Object login(AuthDTO auth){
        UserEntity user = userRepository.findByUsername(auth.username())
                .orElseThrow(() -> new RuntimeException("User não encontrado"));

        if (!passwordEncoder.matches(auth.password(), user.getPassword()))
            throw new RuntimeException("Senha incorreta");

        Map<String, Object> response = new HashMap<>();
        response.put("username", user.getUsername());
        response.put("roles", user.getRoles());
        response.put("token", jwtTokenService.generateToken(user.getUsername(), List.of(user.getRoles())));

        return response;

    }
}
