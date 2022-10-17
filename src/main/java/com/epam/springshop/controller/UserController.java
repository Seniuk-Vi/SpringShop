package com.epam.springshop.controller;

import com.epam.springshop.dto.UserDto;
import com.epam.springshop.dto.group.OnCreate;
import com.epam.springshop.dto.group.OnUpdate;
import com.epam.springshop.model.User;
import com.epam.springshop.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserDto createUser(@RequestBody @Validated(OnCreate.class) UserDto userDto) {
        log.info(this.getClass() + ": method ==> createUser");
        return userService.createUser(userDto);
    }

    @GetMapping("/{userId}")
    public UserDto getUser(@PathVariable @NotBlank long userId) {
        log.info(String.format("%s : method ==> createUser(%s)", this.getClass().getName(), userId));
        return userService.getUser(userId);
    }

    @GetMapping("/{userId}/users")  // check admin
    public List<UserDto> getUsers() {
        log.info(String.format("%s : method ==> getUsers()", this.getClass().getName()));
        return userService.getAllUsers();
    }
    @PutMapping("/{userId}")    // check user
    public UserDto updateUser(@RequestBody @Validated(OnUpdate.class) UserDto userDto) {
        log.info(String.format("%s : method ==> updateUser(%s)", this.getClass().getName(), userDto));
        return userService.updateUser(userDto);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable @NotBlank long userId) {
        log.info(String.format("%s : method ==> deleteUser(%s)", this.getClass().getName(), userId));
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

}
