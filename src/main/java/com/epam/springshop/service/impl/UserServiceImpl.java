package com.epam.springshop.service.impl;

import com.epam.springshop.dto.UserDto;
import com.epam.springshop.model.User;
import com.epam.springshop.repository.impl.UserRepoImpl;
import com.epam.springshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepoImpl userRepoImpl;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userRepoImpl.create(User.builder()
                .login(userDto.getLogin())
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .phone_number(userDto.getPhone_number())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .locale(userDto.getLocale())
                .build());
        return UserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .name(user.getName())
                .surname(user.getSurname())
                .phone_number(user.getPhone_number())
                .email(user.getEmail())
                .role(user.getRole().getRole())
                .password(user.getPassword())
                .locale(user.getLocale())
                .build();
    }

    @Override
    public UserDto getUser(Long obj) {
        User user = userRepoImpl.read(obj);
        return  UserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .name(user.getName())
                .surname(user.getSurname())
                .phone_number(user.getPhone_number())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole().getRole())
                .locale(user.getLocale())
                .build();
    }

    @Override
    public UserDto updateUser(UserDto obj) {

        return null;
    }

    @Override
    public void deleteUser(Long obj) {

    }
}
