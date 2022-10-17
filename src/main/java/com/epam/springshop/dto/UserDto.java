package com.epam.springshop.dto;

import com.epam.springshop.dto.group.OnCreate;
import com.epam.springshop.dto.group.OnUpdate;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;


@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    @NotBlank(message = "'id' shouldn't be empty",groups = OnUpdate.class)
    long id;
    @NotBlank(message = "'login' shouldn't be empty", groups = OnCreate.class)
    String login;
    @NotBlank(message = "'name' shouldn't be empty",groups = OnUpdate.class)
    @NotBlank(message = "'name' shouldn't be empty", groups = OnCreate.class)
    String name;
    @NotBlank(message = "'surname' shouldn't be empty",groups = OnUpdate.class)
    @NotBlank(message = "'surname' shouldn't be empty", groups = OnCreate.class)
    String surname;
    int phone_number;
    @Email(message = "'email' isn't correct")
    @NotBlank(message = "'phone number' shouldn't be empty", groups = OnCreate.class)
    String email;
    @NotBlank(message = "'locale' shouldn't be empty", groups = OnCreate.class)
    String locale;
    @NotBlank(message = "'password' shouldn't be empty", groups = OnCreate.class)
    String password;
    @NotBlank(message = "'role' shouldn't be empty",groups = OnUpdate.class)
    @NotBlank(message = "'role' shouldn't be empty", groups = OnCreate.class)
    String role;
}
