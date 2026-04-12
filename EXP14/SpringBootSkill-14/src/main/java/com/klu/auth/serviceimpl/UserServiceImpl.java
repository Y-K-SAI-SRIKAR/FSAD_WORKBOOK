package com.klu.auth.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.auth.entity.User;
import com.klu.auth.repository.UserRepository;
import com.klu.auth.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public User register(User user) {
        return repo.save(user);
    }

    @Override
    public User login(String email, String password) {
        Optional<User> user = repo.findByEmailAndPassword(email, password);
        return user.orElse(null);
    }

    @Override
    public User getUserById(Long id) {
        return repo.findById(id).orElse(null);
    }
}