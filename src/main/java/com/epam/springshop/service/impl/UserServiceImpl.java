package com.epam.springshop.service.impl;

import com.epam.springshop.dto.UserDto;
import com.epam.springshop.mapper.UserMapper;
import com.epam.springshop.model.User;
import com.epam.springshop.repository.impl.UserRepoImpl;
import com.epam.springshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepoImpl userRepoImpl;

    @Override
    public UserDto createUser(UserDto userDto) {
        // todo check if role exists
        User user = userRepoImpl.create(UserMapper.INSTANCE.mapUser(userDto));
        return UserMapper.INSTANCE.mapUserDto(user);
    }

    @Override
    public UserDto getUser(Long obj) {
        User user = userRepoImpl.read(obj);
        return UserMapper.INSTANCE.mapUserDto(user);
    }

    public List<UserDto> getAllUsers() {
        return UserMapper.INSTANCE.mapUserDtos(userRepoImpl.readAll());
    }

    public UserDto getUserByLogin(String obj) {
        User user = userRepoImpl.readWithLogin(obj);
        return UserMapper.INSTANCE.mapUserDto(user);
    }

    @Override
    public UserDto updateUser(UserDto obj) {
        User user = userRepoImpl.update(UserMapper.INSTANCE.mapUser(obj));
        return UserMapper.INSTANCE.mapUserDto(user);
    }

    @Override
    public void deleteUser(Long obj) {
        userRepoImpl.delete(obj);
    }
}
