package com.example.spotifyclone.service;

import com.example.spotifyclone.respositories.SongRepository;
import com.example.spotifyclone.service.SongService;
import com.example.spotifyclone.service.UserServiceImpl;
import com.example.spotifyclone.config.JwtUtil;
import com.example.spotifyclone.model.User;
import com.example.spotifyclone.respositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private SongService songService;

    @Mock
    private SongRepository songRepository;

    @Mock
    private JwtUtil jwtUtil;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private User user;

    @Before
    public void initializeDummyUser(){
        user.setUsername("tom");
        user.setPassword("jerry");
    }

    @Test
    public void getUser_ReturnsUser_Success(){
        System.out.println("test");
        when(userRepository.findByUsername(anyString())).thenReturn(user);

        User tempUser = userService.getUser(user.getUsername());

        assertEquals(tempUser.getUsername(), user.getUsername());
    }

//    @Test
//    public void login_UserNotFound_Error(){
//
//        when(userRepository.findByUsername(anyString())).thenReturn(null);
//
//        String token = userService.login(user);
//
//        assertEquals(token, null);
//    }
}