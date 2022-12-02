package com.epam.springshop.controller;

import static com.epam.springshop.utils.TestUtils.*;

import com.epam.springshop.controller.assembler.UserAssembler;
import com.epam.springshop.dto.UserDto;
import com.epam.springshop.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.hateoas.MediaTypes;

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
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;
    @Autowired
    @SpyBean
    private UserAssembler userAssembler;

    @Test
    void createUser() throws Exception {
        // given
        when(userService.createUser(any(UserDto.class))).thenReturn(getUserDto());
        UserDto bodyUser = getUserDto();
        bodyUser.setRole(null);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(bodyUser);
        // when then
        mockMvc.perform(post("/user")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaTypes.HAL_JSON))
                .andExpect(jsonPath("$.email", is(USER_EMAIL)))
                .andExpect(jsonPath("$.role", is(USER_DTO_ROLE)))
                .andExpect(jsonPath("$.phoneNumber", is(USER_PHONE_NUMBER)));
        verify(userService, times(1)).createUser(bodyUser);
    }

    @Test
    void getUser() throws Exception {
        // given
        when(userService.getUser(anyLong())).thenReturn(getUserDto());
        // when then
        mockMvc.perform(get("/user/{userId}", USER_ID))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.login").value(USER_LOGIN));
        verify(userService, times(1)).getUser(USER_ID);
    }

    @Test
    void getUsers() throws Exception {
        // given
        when(userService.getAllUsers()).thenReturn(List.of(getUserDto(), getUserDto()));
        // when then
        mockMvc.perform(get("/admin/user/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
        verify(userService, times(1)).getAllUsers();

    }

    @Test
    void updateUser() throws Exception {
        // given
        when(userService.updateUser(anyLong(), any(UserDto.class))).thenReturn(getUserDto());
        UserDto bodyUser = getUserDto();
        bodyUser.setRole(null);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(bodyUser);
        // when then
        mockMvc.perform(put("/user/{userId}", USER_ID)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaTypes.HAL_JSON))
                .andExpect(jsonPath("$.email", is(USER_EMAIL)))
                .andExpect(jsonPath("$.role", is(USER_DTO_ROLE)))
                .andExpect(jsonPath("$.phoneNumber", is(USER_PHONE_NUMBER)));
        verify(userService, times(1)).updateUser(anyLong(), any(UserDto.class));


    }

    @Test
    void banUser() throws Exception {
        // given
        when(userService.banUser(anyLong())).thenReturn(getUserDto());
        // when then
        mockMvc.perform(put("/admin/user/ban/{userId}", USER_ID))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaTypes.HAL_JSON))
                .andExpect(jsonPath("$.email", is(USER_EMAIL)))
                .andExpect(jsonPath("$.role", is(USER_DTO_ROLE)))
                .andExpect(jsonPath("$.phoneNumber", is(USER_PHONE_NUMBER)));
        verify(userService, times(1)).banUser(anyLong());

    }

    @Test
    void unBan() throws Exception {
        // given
        when(userService.unBan(anyLong())).thenReturn(getUserDto());
        // when then
        mockMvc.perform(put("/admin/user/unBan/{userId}", USER_ID))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaTypes.HAL_JSON))
                .andExpect(jsonPath("$.email", is(USER_EMAIL)))
                .andExpect(jsonPath("$.role", is(USER_DTO_ROLE)))
                .andExpect(jsonPath("$.phoneNumber", is(USER_PHONE_NUMBER)));
        verify(userService, times(1)).unBan(anyLong());
    }

    @Test
    void deleteUser() throws Exception {
        // given

        // when then
        mockMvc.perform(delete("/user/{userId}", USER_ID))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        verify(userService, times(1)).deleteUser(anyLong());
    }
}