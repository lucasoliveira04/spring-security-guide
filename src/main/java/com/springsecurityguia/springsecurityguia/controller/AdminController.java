package com.springsecurityguia.springsecurityguia.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @GetMapping("/profile")
    public ResponseEntity<String> profileAdmin(){
        return ResponseEntity.ok("Profile Admin");
    }
}
