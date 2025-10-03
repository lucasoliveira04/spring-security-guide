package com.springsecurityguia.springsecurityguia.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public record RegisterUserRequestDTO(String nome, String email, String username, String password, LocalDateTime dataCriacao, String roles) implements Serializable {}
