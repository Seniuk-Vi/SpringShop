package com.epam.springshop.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDto {
    long id;
    String login;
    String name;
    String surname;
    int phone_number;
    String email;
    String locale;
    String password;
    String role;
}
