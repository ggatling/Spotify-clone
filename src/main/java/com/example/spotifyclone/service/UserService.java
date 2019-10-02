package com.example.spotifyclone.service;

import com.example.spotifyclone.model.User;
import org.springframework.http.HttpStatus;
//talks to the database
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public Iterable<User> listUsers();

    public User getUser(String username);
    //will get a token when the user logs in

    public String createUser(User newUser);
    //when a user signs up a token will be generated

    public User login(String username, String password);

    public HttpStatus deleteById(Long userId);

    public User addSong(String username, Long songId);

    public String login(User user);



}

