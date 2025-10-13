package com.springsecurityguia.springsecurityguia.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class CustomOAuth2SuccessHandler implements AuthenticationSuccessHandler{
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        OAuth2User oauth2user =  (OAuth2User) authentication.getPrincipal();
        Map<String,Object> attributes = oauth2user.getAttributes();

        String nome =  (String) attributes.get("name");
        String email =  (String) attributes.get("email");

        System.out.println("Nome : " + nome);
        System.out.println("Email : " + email);

        response.sendRedirect("/home");
    }
}
