package com.springsecurityguia.springsecurityguia.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String hello(Authentication authentication) {
        OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal();
        String nome = (String) oauth2User.getAttributes().get("name");
        String email = (String) oauth2User.getAttributes().get("email");

        String typeLogin = null;

        if (authentication instanceof OAuth2AuthenticationToken oauth2Token) {
            typeLogin = oauth2Token.getAuthorizedClientRegistrationId();
        }

        return "Nome: " + nome + " | Email: " + email + " | TypeLogin: " + typeLogin;
    }
}
