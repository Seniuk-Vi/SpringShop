package com.epam.springshop;

import com.epam.springshop.model.Role;
import com.epam.springshop.model.enums.StatusEnum;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Role> m = new HashMap<>();
        Role r = new Role(1, "role");
        m.put(4, r);
        System.out.println(m.get(4));
        r = new Role(1, "new role");
        System.out.println(m.get(4));
        StatusEnum statusEnum = StatusEnum.CREATED;
    }
}
