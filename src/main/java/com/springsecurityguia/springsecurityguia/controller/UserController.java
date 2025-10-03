package com.springsecurityguia.springsecurityguia.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/dashboard")
    public ResponseEntity<String> dashboardUser(){
        return  ResponseEntity.ok("Dashboard");
    }

    @GetMapping("/sales")
    public ResponseEntity<String> salesUser(){
        return  ResponseEntity.ok("Sales");
    }

    @GetMapping("/profile")
    public ResponseEntity<String> profileUser(){
        return  ResponseEntity.ok("Profile");
    }
}
