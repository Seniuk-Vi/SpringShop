package com.epam.springshop.controller;

import static com.epam.springshop.utils.TestUtils.*;

import com.epam.springshop.controller.assembler.UserAssembler;
import com.epam.springshop.dto.UserDto;
import com.epam.springshop.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = {UserController.class})
@ActiveProfiles("test")
@ContextConfiguration(classes = {UserAssembler.class})
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;

    @Test
    void createUser() throws Exception {
        // given
        when(userService.createUser(any(UserDto.class))).thenReturn(getUserDto());
        UserDto bodyUser = getUserDto();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(bodyUser);

        // when then
        mockMvc.perform(post("/user")
                        .content(json)
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andReturn();
        verify(userService, times(1)).createUser(bodyUser);

    }

    @Test
    void getUser() throws Exception {
        when(userService.getUser(anyLong())).thenReturn(getUserDto());
        mockMvc.perform(get("/user")
                        .queryParam("userId","1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.login").value(USER_LOGIN));
        verify(userService, times(1)).getUser(1L);
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