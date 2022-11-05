package com.epam.springshop.service.impl;

import com.epam.springshop.dto.UserDto;
import com.epam.springshop.exceptions.RoleNotFoundException;
import com.epam.springshop.exceptions.UserNotFoundException;
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
        log.info(String.format("%s : method ==> createUser(%s)", this.getClass().getName(), obj));
        // todo check if role exists
        User user = UserMapper.INSTANCE.mapUser(obj);
        user.setEnabled(true);
        return UserMapper.INSTANCE.mapUserDto(userRepoImpl.create(user));
    }

    @Override
    public UserDto getUser(Long obj) {
        log.info(String.format("%s : method ==> getUser(%s)", this.getClass().getName(), obj));
        User user = userRepoImpl.read(obj);
        if(user == null){
            throw new UserNotFoundException();
        }
        return UserMapper.INSTANCE.mapUserDto(user);
    }

    public List<UserDto> getAllUsers() {
        log.info(String.format("%s : method ==> getAllUsers()", this.getClass().getName()));
        return UserMapper.INSTANCE.mapUserDtos(userRepoImpl.readAll());
    }

    public UserDto getUserByLogin(String obj) {
        log.info(String.format("%s : method ==> getUserByLogin(%s)", this.getClass().getName(), obj));
        User user = userRepoImpl.readWithLogin(obj);
        return UserMapper.INSTANCE.mapUserDto(user);
    }

    @Override
    public UserDto updateUser(long userID, UserDto obj) {
        log.info(String.format("%s : method ==> updateUser(%s)", this.getClass().getName(), obj));
        if (userRepoImpl.read(userID) == null) {
            throw new UserNotFoundException();
        }
        obj.setId(userID);
        User user = userRepoImpl.update(UserMapper.INSTANCE.mapUser(obj));
        return UserMapper.INSTANCE.mapUserDto(user);
    }

    @Override
    public UserDto banUser(long userId) {
        log.info(String.format("%s : method ==> banUser(%s)", this.getClass().getName(), userId));
        User user = userRepoImpl.read(userId);
        user.setEnabled(false);
        User updateUser = userRepoImpl.update(user);
        return UserMapper.INSTANCE.mapUserDto(updateUser);
    }
    @Override
    public UserDto unBan(long userId) {
        log.info(String.format("%s : method ==> unBan(%s)", this.getClass().getName(), userId));
        User user = userRepoImpl.read(userId);
        user.setEnabled(true);
        User updateUser = userRepoImpl.update(user);
        return UserMapper.INSTANCE.mapUserDto(updateUser);
    }

    @Override
    public void deleteUser(Long obj) {
        log.info(String.format("%s : method ==> deleteUser(%s)", this.getClass().getName(), obj));
        userRepoImpl.delete(obj);
    }
}
