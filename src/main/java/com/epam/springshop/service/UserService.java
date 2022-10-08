package com.epam.springshop.service;

import com.epam.springshop.dto.UserDto;

public interface UserService {

    public UserDto createUser(UserDto obj);
    public UserDto getUser(Long obj);
    public UserDto updateUser(UserDto obj);
    public void deleteUser(Long obj);
}
