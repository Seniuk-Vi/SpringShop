package com.epam.springshop.dto;

import com.epam.springshop.dto.group.OnCreate;
import com.epam.springshop.dto.group.OnUpdate;
import com.epam.springshop.exceptions.validator.LocaleConstraint;
import com.epam.springshop.exceptions.validator.PhoneNumberConstraint;
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
    long id;
    @NotBlank(message = "{userdto.login.notempty}", groups = OnCreate.class)
    String login;
    @NotBlank(message = "{userdto.name.notempty}", groups = {OnUpdate.class, OnCreate.class})
    String name;
    @NotBlank(message = "{userdto.surname.notempty}", groups = {OnUpdate.class,OnCreate.class})
    String surname;
    @PhoneNumberConstraint(message = "{userdto.phonenumber.notempty}", groups = {OnUpdate.class,OnCreate.class})
    String phoneNumber;
    @Email(message = "{userdto.email.notcorrect}")
    @NotBlank(message = "{userdto.email.notempty}", groups = {OnCreate.class,OnUpdate.class})
    String email;
    @NotBlank(message = "{userdto.locale.notempty}", groups = {OnUpdate.class,OnCreate.class})
    @LocaleConstraint(message = "{userdto.locale.notcorrect}")
    String locale;
    @NotBlank(message = "{userdto.password.notempty}", groups = {OnCreate.class,OnUpdate.class})
    String password;
   // @NotBlank(message = "{userdto.role.notempty}", groups = OnUpdate.class)
    @Null(message = "{userdto.role.empty}", groups = OnCreate.class)
    String role;
}
