package com.epam.springshop.repository.impl;

import com.epam.springshop.model.Role;
import com.epam.springshop.model.User;
import com.epam.springshop.repository.Repo;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserRepoImpl implements Repo<User> {

    private final Map<Number,User> users = new HashMap<>();
    RoleRepoImpl roleRepo = new RoleRepoImpl(); // better make roleService
    long idCounter=0;
    @Override
    public User create(User obj) {
        obj.setId(++idCounter);
        obj.setRole(roleRepo.create(Role.builder().build()));
        users.put(idCounter,obj);
        return obj;
    }

    @Override
    public User read(Long field) {
        return users.get(field);
    }

    @Override
    public User update(User obj) {
        delete(obj.getId());
        create(obj);
        return obj;
    }

    @Override
    public void delete(Long field) {
        users.remove(field);

    }
}
