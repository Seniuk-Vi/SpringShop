package com.epam.springshop.controller;

import com.epam.springshop.dto.UserDto;
import com.epam.springshop.model.User;
import com.epam.springshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto){
        System.out.println(userDto);
        return userService.createUser(userDto);

    }

    @GetMapping("/{userId}")
    public UserDto getUser(@PathVariable long userId){
        System.out.println(userId);
        return userService.getUser(userId);
    }

    @PutMapping
    public UserDto updateUser(@RequestBody UserDto userDto){
        System.out.println(userDto);
        return userService.updateUser(userDto);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@RequestParam long userId){
        System.out.println(userId);
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

}
