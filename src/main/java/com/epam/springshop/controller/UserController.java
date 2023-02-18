package com.epam.springshop.controller;

import com.epam.springshop.api.UserApi;
import com.epam.springshop.controller.assembler.UserAssembler;
import com.epam.springshop.controller.model.UserModel;
import com.epam.springshop.dto.UserDto;
import com.epam.springshop.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;
    private final UserAssembler userAssembler ;

    @Override
    public UserModel createUser(UserDto userDto) {
        log.info(this.getClass() + ": method ==> createUser");
        UserDto user = userService.createUser(userDto);
        return userAssembler.toModel(user);
    }

    @Override
    public UserModel getUser(long userId) {
        log.info(String.format("%s : method ==> createUser(%s)", this.getClass().getName(), userId));
        UserDto user = userService.getUser(userId);
        return userAssembler.toModel(user);
    }

    @Override
    public List<UserDto> getUsers() {
        log.info(String.format("%s : method ==> getUsers()", this.getClass().getName()));
        return userService.getAllUsers();
    }

    @Override
    public UserModel updateUser(long userId, UserDto userDto) {
        log.info(String.format("%s : method ==> updateUser(%s)", this.getClass().getName(), userDto));
        UserDto user = userService.updateUser(userId,userDto);
        return userAssembler.toModel(user);

    }
    @Override
    public UserModel banUser(long userId) {
        log.info(String.format("%s : method ==> banUser(%s)", this.getClass().getName(), userId));
        UserDto user = userService.banUser(userId);
        return userAssembler.toModel(user);

    }
    @Override
    public UserModel unBan(long userId) {
        log.info(String.format("%s : method ==> unBan(%s)", this.getClass().getName(), userId));
        UserDto user = userService.unBan(userId);
        return userAssembler.toModel(user);

    }
    @Override
    public ResponseEntity<Void> deleteUser(long userId) {
        log.info(String.format("%s : method ==> deleteUser(%s)", this.getClass().getName(), userId));
        userService.deleteUser(userId);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).build();
    }

}
