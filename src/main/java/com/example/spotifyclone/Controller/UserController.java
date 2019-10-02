package com.example.spotifyclone.Controller;

import com.example.spotifyclone.model.JwtResponse;
import com.example.spotifyclone.model.User;
import com.example.spotifyclone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        return ResponseEntity.ok(new JwtResponse(userService.login(user)));
    }

    @GetMapping("admin/user/list")
    public Iterable<User> listUsers(){
        return userService.listUsers();
    }

    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@RequestBody User newUser) {
        return ResponseEntity.ok(new JwtResponse(userService.createUser(newUser)));
    }
    //added functionality that allows signup to generate a token like login

    @GetMapping("/login/{username}/{password}")
    public User login(@PathVariable String username,@PathVariable String password){
        return  userService.login(username, password);
    }

    @DeleteMapping("/user/{userId}")
    public HttpStatus deleteUserById(@PathVariable Long userId){
        return userService.deleteById(userId);
    }
    @PutMapping("/user/{username}/{songId}")
    public User addSong(@PathVariable String username, @PathVariable Long songId){
        return userService.addSong(username, songId);
    }
}
