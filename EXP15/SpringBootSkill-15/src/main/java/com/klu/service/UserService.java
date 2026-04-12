package com.klu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.klu.entity.User;
import com.klu.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    // Save new user
    public User saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    // Find by username
    public User findByUsername(String username) {
        return repo.findByUsername(username).orElse(null);
    }
}


