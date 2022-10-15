package com.epam.springshop.repository.impl;

import com.epam.springshop.exceptions.UserNotFoundException;
import com.epam.springshop.model.Role;
import com.epam.springshop.model.User;
import com.epam.springshop.repository.Repo;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserRepoImpl implements Repo<User> {

    private final Map<Number, User> users = new HashMap<>();
    RoleRepoImpl roleRepo = new RoleRepoImpl(); // better make roleService
    long idCounter = 0;

    @Override
    public User create(User obj) {
        obj.setId(++idCounter);
//        obj.setRole(roleRepo.create(Role.builder().build()));
        users.put(idCounter, obj);
        return obj;
    }

    @Override
    public User read(Long field) {
        User user = users.get(field);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return users.get(field);
    }

    @Override
    public List<User> readAll() {
        return new ArrayList<User>(users.values());
    }

    public User readWithLogin(String field) {
        return users.values().stream()
                .filter(user1 -> user1.getLogin().equals(field))
                .findFirst().orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User update(User obj) {
        User user = read(obj.getId());
        user = obj;
        return user;
    }

    @Override
    public void delete(Long field) {
        users.remove(field);

    }
}
