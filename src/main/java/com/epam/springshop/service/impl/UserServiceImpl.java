package com.epam.springshop.service.impl;

import com.epam.springshop.dto.UserDto;
import com.epam.springshop.exceptions.EntityIllegalArgumentException;
import com.epam.springshop.exceptions.UserNotFoundException;
import com.epam.springshop.mapper.UserMapper;
import com.epam.springshop.model.User;
import com.epam.springshop.model.enums.RoleEnum;
import com.epam.springshop.repository.UserRepoImpl;
import com.epam.springshop.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {

    private final UserRepoImpl userRepoImpl;

    @Override
    public UserDto createUser(UserDto obj) {
        log.info(String.format("%s : method ==> createUser(%s)", this.getClass().getName(), obj));
        User user = UserMapper.INSTANCE.mapUser(obj);
        // check if login or email exists
        List<EntityIllegalArgumentException> exceptions = new ArrayList<>();
        if (userRepoImpl.findUserByLogin(user.getLogin()) != null) {
            exceptions.add(new EntityIllegalArgumentException("Login already in use"));
        }
        if (userRepoImpl.findUserByEmail(user.getEmail()) != null) {
            exceptions.add(new EntityIllegalArgumentException("Email already in use"));
        }
        if (userRepoImpl.findUserByPhoneNumber(user.getPhoneNumber()) != null) {
            exceptions.add(new EntityIllegalArgumentException("Phone number already in use"));
        }
        if (exceptions.size() > 0) {
            String messages = exceptions.toString();
            throw new EntityIllegalArgumentException(messages);
        }
        // todo: hash password
        // set default data to user
        user.setEnabled(true);
        user.setRole(RoleEnum.USER);
        return UserMapper.INSTANCE.mapUserDto(userRepoImpl.save(user));
    }

    @Override
    public UserDto getUser(Long obj) {
        log.info(String.format("%s : method ==> getUser(%s)", this.getClass().getName(), obj));
        User user = userRepoImpl.findById(obj).orElseThrow(UserNotFoundException::new);
        return UserMapper.INSTANCE.mapUserDto(user);
    }

    public List<UserDto> getAllUsers() {
        log.info(String.format("%s : method ==> getAllUsers()", this.getClass().getName()));
        return UserMapper.INSTANCE.mapUserDtos(userRepoImpl.findAll());
    }

    public UserDto getUserByLogin(String obj) {
        log.info(String.format("%s : method ==> getUserByLogin(%s)", this.getClass().getName(), obj));
        User user = userRepoImpl.findUserByLogin(obj);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return UserMapper.INSTANCE.mapUserDto(user);
    }

    @Override
    @Transactional
    public UserDto updateUser(long userId, UserDto obj) {
        log.info(String.format("%s : method ==> updateUser(%s)", this.getClass().getName(), obj));
        User user = userRepoImpl.findById(userId).orElseThrow(UserNotFoundException::new);
        // check fields
        List<EntityIllegalArgumentException> exceptions = new ArrayList<>();

        if (!obj.getPhoneNumber().equals(user.getPhoneNumber()) && userRepoImpl.existsByPhoneNumber(obj.getPhoneNumber())) {
            exceptions.add(new EntityIllegalArgumentException("Phone number already in use"));
        }
        if (!obj.getEmail().equals(user.getEmail()) && userRepoImpl.existsByEmail(obj.getEmail())) {
            exceptions.add(new EntityIllegalArgumentException("Email already in use"));
        }
        if (exceptions.size() > 0) {
            String messages = exceptions.toString();
            throw new EntityIllegalArgumentException(messages);
        }
        // todo: hash password

        // set fields
        user.setName(obj.getName());
        user.setSurname(obj.getSurname());
        user.setPhoneNumber(obj.getPhoneNumber());
        user.setPassword(obj.getPassword());
        user.setEmail(obj.getEmail());
        user.setLocale(obj.getLocale());
        return UserMapper.INSTANCE.mapUserDto(user);
    }

    @Override
    @Transactional
    public UserDto banUser(long userId) {
        log.info(String.format("%s : method ==> banUser(%s)", this.getClass().getName(), userId));
        User user = userRepoImpl.findById(userId).orElseThrow(UserNotFoundException::new);
        user.setEnabled(false);
        return UserMapper.INSTANCE.mapUserDto(user);
    }

    @Override
    @Transactional
    public UserDto unBan(long userId) {
        log.info(String.format("%s : method ==> unBan(%s)", this.getClass().getName(), userId));
        User user = userRepoImpl.findById(userId).orElseThrow(UserNotFoundException::new);
        user.setEnabled(true);
        return UserMapper.INSTANCE.mapUserDto(user);
    }

    @Override
    public void deleteUser(Long obj) {
        log.info(String.format("%s : method ==> deleteUser(%s)", this.getClass().getName(), obj));
        userRepoImpl.findById(obj).orElseThrow(UserNotFoundException::new);
        userRepoImpl.deleteById(obj);
    }
}
