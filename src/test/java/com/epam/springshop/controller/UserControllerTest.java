package com.epam.springshop.controller;

import com.epam.springshop.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = {UserController.class})
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;

    @Test
    void createUser() {
    }

    @Test
    void getUser() {

    }

    @Test
    void getUsers() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void banUser() {
    }

    @Test
    void unBan() {
    }

    @Test
    void deleteUser() {
    }
}