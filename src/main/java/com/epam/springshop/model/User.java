package com.epam.springshop.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User{
    long id;
    String login;
    String name;
    String surname;
    int phone_number;
    String email;
    String locale;
    Role role;
    String password;
}
