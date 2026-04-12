package com.klu.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.auth.entity.User;
import com.klu.auth.service.UserService;

@CrossOrigin(origins = "http://localhost:3000") // change if your React runs on 3003
@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return service.login(user.getEmail(), user.getPassword());
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        return service.getUserById(id);
    }
}