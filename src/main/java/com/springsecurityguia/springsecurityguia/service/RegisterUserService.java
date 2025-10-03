package com.springsecurityguia.springsecurityguia.service;

import com.springsecurityguia.springsecurityguia.dto.RegisterUserRequestDTO;
import com.springsecurityguia.springsecurityguia.entity.UserEntity;
import com.springsecurityguia.springsecurityguia.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RegisterUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterUserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity registerUser(RegisterUserRequestDTO userDTO) {
        UserEntity user = UserEntity.builder()
                .nome(userDTO.nome())
                .username(userDTO.username())
                .email(userDTO.email())
                .password(passwordEncoder.encode(userDTO.password()))
                .dataCriacao(LocalDateTime.now())
                .roles(userDTO.roles())
                .build();

        return userRepository.save(user);
    }
}
