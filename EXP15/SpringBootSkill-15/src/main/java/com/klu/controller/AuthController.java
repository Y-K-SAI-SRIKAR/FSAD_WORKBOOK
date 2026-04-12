package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;

import com.klu.dto.AuthRequest;
import com.klu.dto.AuthResponse;
import com.klu.entity.User;
import com.klu.security.JwtUtil;
import com.klu.service.UserService;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    // 🔹 REGISTER API
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userService.saveUser(user);
        return "User Registered Successfully";
    }

    // 🔹 LOGIN API
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        authManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
            )
        );

        String token = jwtUtil.generateToken(request.getUsername());

        return new AuthResponse(token);
    }
}