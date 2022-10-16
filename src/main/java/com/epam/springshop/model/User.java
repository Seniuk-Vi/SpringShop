package com.epam.springshop.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
    private long id;
    private String login;
    private String name;
    private String surname;
    private int phone_number;
    private String email;
    private String locale;
    private Role role;
    private String password;
}
