package com.springsecurityguia.springsecurityguia.dto;

import java.io.Serializable;

public record AuthDTO(String username, String password) implements Serializable {
}
