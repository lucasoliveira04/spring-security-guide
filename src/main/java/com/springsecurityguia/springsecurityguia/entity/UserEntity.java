package com.springsecurityguia.springsecurityguia.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;
    private String username;
    private String password;
    private String email;
    private LocalDateTime  dataCriacao;

    private String roles;
}
