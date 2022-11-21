package com.epam.springshop.api;

import com.epam.springshop.controller.model.UserModel;
import com.epam.springshop.dto.UserDto;
import com.epam.springshop.dto.group.OnCreate;
import com.epam.springshop.dto.group.OnUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Api(tags = "User management API")

public interface UserApi {
    @ApiImplicitParams({@ApiImplicitParam(name = "userDto", paramType = "body", required = true, value = "User object", dataTypeClass = UserDto.class)})
    @ApiOperation("Create user")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/user")
    UserModel createUser(@RequestBody @Validated(OnCreate.class) UserDto userDto);

    @ApiImplicitParams({@ApiImplicitParam(name = "userId", paramType = "path", required = true, value = "User id", dataTypeClass = Long.class)})

    @ApiOperation("Get user")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user/{userId}")
    UserModel getUser(@PathVariable @NotBlank long userId);

    //todo: pass adminId or not? @ApiImplicitParams({@ApiImplicitParam(name = "userId", paramType = "path", required = true, value = "Admin id",dataTypeClass = UserDto.class)})
    @ApiOperation("Get all users")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/admin/user/users")
    List<UserDto> getUsers();

    @ApiImplicitParams({@ApiImplicitParam(name = "userDto", paramType = "body", required = true, value = "UserDto fields to update", dataTypeClass = UserDto.class),
            @ApiImplicitParam(name = "userId", paramType = "path", required = true, value = "Confirm user with", dataTypeClass = Long.class)})
    @ApiOperation("Update user")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/user/{userId}")
    UserModel updateUser(@PathVariable @NotBlank long userId, @RequestBody @Validated(OnUpdate.class) UserDto userDto);

    @ApiImplicitParams({@ApiImplicitParam(name = "userId", paramType = "path", required = true, value = "User id to ban", dataTypeClass = Long.class)})
    @ApiOperation("Ban user")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/admin/user/ban/{userId}")
    UserModel banUser(@PathVariable @NotBlank long userId);

    @ApiImplicitParams({@ApiImplicitParam(name = "userId", paramType = "path", required = true, value = "User id to unban", dataTypeClass = Long.class)})
    @ApiOperation("unBan user")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/admin/user/unBan/{userId}")
    UserModel unBan(@PathVariable @NotBlank long userId);

    @ApiImplicitParams({@ApiImplicitParam(name = "userId", paramType = "path", required = true, value = "Confirm user with", dataTypeClass = Long.class)})
    @ApiOperation("Delete users")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/user/{userId}")
    ResponseEntity<Void> deleteUser(@PathVariable @NotBlank long userId);


}
