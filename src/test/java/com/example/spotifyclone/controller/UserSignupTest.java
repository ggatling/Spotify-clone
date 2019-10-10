package com.example.spotifyclone.controller;


import com.example.spotifyclone.Controller.UserController;
import com.example.spotifyclone.config.JwtUtil;
import com.example.spotifyclone.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)

@WebMvcTest(UserController.class)
public class UserSignupTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private JwtUtil jwtUtil;
    @Test
    public void signUp_Success() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(createUserSignUpInJson("mary", "jane", "ROLE_ADMIN"));
        //if successful then it'll return horray
        when(userService.createUser(any())).thenReturn("hooray");
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"token\":\"hooray\"}"))
                //method returns the response after the method executes and stores it in the MvcResult object
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }
    private static String createUserSignUpInJson(String username, String password, String role) {
        return "{ \"username\": \"" + username + "\", " +
                "\"password\":\"" + password + "\", " +
                "\"userRole\": { \"name\": \""+ role  + "\" } "+
                "}";
    }
}
