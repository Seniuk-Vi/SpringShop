package com.epam.springshop.service;

import com.epam.springshop.dto.UserDto;

import java.util.List;

public interface UserService {

     UserDto createUser(UserDto obj);
     UserDto getUser(Long obj);
     List<UserDto> getAllUsers();
     UserDto updateUser(UserDto obj);
     void deleteUser(Long obj);
}
