package com.example.spotifyclone.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/spotify")
    public String helloWorld(){
        return "Hello world";
    }
}
