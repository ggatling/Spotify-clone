package com.example.spotifyclone.service;

import com.example.spotifyclone.model.User;
import org.springframework.http.HttpStatus;

public interface UserService {
    public Iterable<User> listUsers();

    public User createUser(User newUser);

    public User login(String username, String password);

    public HttpStatus deleteById(Long userId);

}

