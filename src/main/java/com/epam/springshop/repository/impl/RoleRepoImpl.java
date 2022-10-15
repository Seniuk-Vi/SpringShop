package com.epam.springshop.repository.impl;

import com.epam.springshop.exceptions.UserNotFoundException;
import com.epam.springshop.model.Role;
import com.epam.springshop.model.User;
import com.epam.springshop.repository.Repo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RoleRepoImpl implements Repo<Role> {
    private final Map<Number, Role> roles = new HashMap<>();
    long idCounter = 0;

    @Override
    public Role create(Role obj) {
        obj.setId(++idCounter);
        obj.setRole("user");
        roles.put(idCounter, obj);
        return obj;
    }

    @Override
    public Role read(Long field) {
        Role role = roles.get(field);
        if (role == null) {
            throw new UserNotFoundException();
        }
        return role;
    }

    @Override
    public List<Role> readAll() {
        return new ArrayList<>(roles.values());
    }

    @Override
    public Role update(Role obj) {
        Role role = read(obj.getId());
        role.setRole(obj.getRole());
        return role;
    }

    @Override
    public void delete(Long field) {
        roles.remove(field);
    }
}
