package com.klu.auth.service;

import com.klu.auth.entity.User;

import com.klu.auth.entity.User;

public interface UserService {
    User register(User user);
    User login(String email, String password);
    User getUserById(Long id);
}