package com.epam.springshop.service.impl;

import com.epam.springshop.dto.UserDto;
import com.epam.springshop.exceptions.RoleNotFoundException;
import com.epam.springshop.mapper.UserMapper;
import com.epam.springshop.model.User;
import com.epam.springshop.repository.impl.UserRepoImpl;
import com.epam.springshop.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepoImpl userRepoImpl;
    private final RoleServiceImpl roleService;
    @Override
    public UserDto createUser(UserDto obj) {
        // todo check if role exists
        if(roleService.getRole(obj.getRole())==null){
            throw new RoleNotFoundException();
        }
        log.info(String.format("%s : method ==> createUser(%s)", this.getClass().getName(),obj));
        User user = userRepoImpl.create(UserMapper.INSTANCE.mapUser(obj));
        return UserMapper.INSTANCE.mapUserDto(user);
    }

    @Override
    public UserDto getUser(Long obj) {
        log.info(String.format("%s : method ==> getUser(%s)", this.getClass().getName(),obj));
        User user = userRepoImpl.read(obj);
        return UserMapper.INSTANCE.mapUserDto(user);
    }

    public List<UserDto> getAllUsers() {
        log.info(String.format("%s : method ==> getAllUsers()", this.getClass().getName()));
        return UserMapper.INSTANCE.mapUserDtos(userRepoImpl.readAll());
    }

    public UserDto getUserByLogin(String obj) {
        log.info(String.format("%s : method ==> getUserByLogin(%s)", this.getClass().getName(),obj));
        User user = userRepoImpl.readWithLogin(obj);
        return UserMapper.INSTANCE.mapUserDto(user);
    }

    @Override
    public UserDto updateUser(UserDto obj) {
        log.info(String.format("%s : method ==> updateUser(%s)", this.getClass().getName(),obj));
        User user = userRepoImpl.update(UserMapper.INSTANCE.mapUser(obj));
        return UserMapper.INSTANCE.mapUserDto(user);
    }

    @Override
    public void deleteUser(Long obj) {
        log.info(String.format("%s : method ==> deleteUser(%s)", this.getClass().getName(),obj));
        userRepoImpl.delete(obj);
    }
}
