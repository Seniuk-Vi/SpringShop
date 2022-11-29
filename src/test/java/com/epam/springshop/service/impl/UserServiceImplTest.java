package com.epam.springshop.service.impl;

import static com.epam.springshop.utils.TestUtils.*;

import com.epam.springshop.dto.UserDto;
import com.epam.springshop.exceptions.impl.UserNotFoundException;
import com.epam.springshop.mapper.UserMapper;
import com.epam.springshop.model.User;
import com.epam.springshop.model.enums.RoleEnum;
import com.epam.springshop.repository.UserRepoImpl;
import com.epam.springshop.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userServiceImpl;
    @Mock
    private UserRepoImpl userRepoImpl;
    @Mock

    private UserMapper userMapper;

    @Test
    void createUser() {
        //given
        UserDto userDto = getUserDto();
        User user = TestUtils.getUser();
        when(userRepoImpl.findUserByLogin(user.getLogin())).thenReturn(null);
        when(userRepoImpl.findUserByEmail(user.getEmail())).thenReturn(null);
        when(userRepoImpl.findUserByPhoneNumber(userDto.getPhoneNumber())).thenReturn(null);
        when(userRepoImpl.save(any(User.class))).thenReturn(user);
        //when
        UserDto createdUser = userServiceImpl.createUser(userDto);
        //then
        assertEquals(userDto, createdUser);
    }

    @Test
    void getUser() {
        //given
        UserDto userDto = getUserDto();
        User user = TestUtils.getUser();
        when(userRepoImpl.findById(userDto.getId())).thenReturn(Optional.of(user));
        //when
        UserDto createdUser = userServiceImpl.getUser(user.getId());
        //then
        assertEquals(userDto, createdUser);
    }

    @Test
    void getAllUsers() {
        //given
        List<UserDto> userDtos = List.of(TestUtils.getUserDto(), TestUtils.getUserDto());
        List<User> users = List.of(TestUtils.getUser(), TestUtils.getUser());
        when(userRepoImpl.findAll()).thenReturn(users);
        //when
        List<UserDto> createdUserDtos = userServiceImpl.getAllUsers();
        //then
        assertEquals(userDtos, createdUserDtos);
    }

    @Test
    void getUserByLogin() {
        //given
        UserDto userDto = getUserDto();
        User user = TestUtils.getUser();
        when(userRepoImpl.findUserByLogin(userDto.getLogin())).thenReturn(user);
        //when
        UserDto createdUser = userServiceImpl.getUserByLogin(userDto.getLogin());
        //then
        assertEquals(userDto, createdUser);
    }

    @Test
    void updateUser() {
        //given
        UserDto userDto = getUserDto();
        User user = TestUtils.getUser();
        user.setName("Paul"); // imitate updating
        when(userRepoImpl.findById(userDto.getId())).thenReturn(Optional.of(user));
//        when(userRepoImpl.existsByPhoneNumber(userDto.getPhoneNumber())).thenReturn(false);
//        when(userRepoImpl.existsByEmail(userDto.getEmail())).thenReturn(false);
        //when
        UserDto updatedUser = userServiceImpl.updateUser(userDto.getId(), userDto);  // maybe give another id?
        //then
        assertEquals(userDto, updatedUser);
    }

    @Test
    void banUser() {
        //given
        UserDto userDto = getUserDto();
        User user = TestUtils.getUser();
        when(userRepoImpl.findById(userDto.getId())).thenReturn(Optional.of(user));
        //when
        UserDto createdUser = userServiceImpl.banUser(userDto.getId());
        //then
        assertEquals(userDto, createdUser); // can't check banned or not
        assertFalse(user.isEnabled()); // can't check banned or not
    }

    @Test
    void unBan() {
        //given
        UserDto userDto = getUserDto();
        User user = TestUtils.getUser();
        when(userRepoImpl.findById(userDto.getId())).thenReturn(Optional.of(user));
        //when
        UserDto createdUser = userServiceImpl.unBan(userDto.getId());
        //then
        assertEquals(userDto, createdUser);
        assertTrue(user.isEnabled()); // can't check banned or not

    }

    @Test
    void deleteUser() {
        //given
        UserDto userDto = getUserDto();
        User user = TestUtils.getUser();
        when(userRepoImpl.findById(userDto.getId())).thenReturn(Optional.of(user));
        //when
        userServiceImpl.deleteUser(userDto.getId());
        //then
        verify(userRepoImpl, times(1)).deleteById(userDto.getId());
    }
}