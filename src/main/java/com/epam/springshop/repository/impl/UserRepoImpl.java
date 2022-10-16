package com.epam.springshop.repository.impl;

import com.epam.springshop.exceptions.UserNotFoundException;
import com.epam.springshop.model.Role;
import com.epam.springshop.model.User;
import com.epam.springshop.repository.Repo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;
@Slf4j
@Component
public class UserRepoImpl implements Repo<User> {

    private final Map<Number, User> users = new HashMap<>();
    RoleRepoImpl roleRepo = new RoleRepoImpl(); // better make roleService
    long idCounter = 0;

    @Override
    public User create(User obj) {
        log.info(String.format("%s : method ==> create(%s)", this.getClass().getName(),obj));
        obj.setId(++idCounter);
//        obj.setRole(roleRepo.create(Role.builder().build()));
        users.put(idCounter, obj);
        return obj;
    }

    @Override
    public User read(Long field) {
        log.info(String.format("%s : method ==> read(%s)", this.getClass().getName(),field));
        return users.get(field);
    }

    @Override
    public List<User> readAll() {
        log.info(String.format("%s : method ==> readAll()", this.getClass().getName()));
        return new ArrayList<>(users.values());
    }

    public User readWithLogin(String field) {
        log.info(String.format("%s : method ==> readWithLogin(%s)", this.getClass().getName(),field));
        return users.values().stream()
                .filter(user1 -> user1.getLogin().equals(field))
                .findFirst().orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User update(User obj) {
        log.info(String.format("%s : method ==> update(%s)", this.getClass().getName(),obj));
        User user = read(obj.getId());
        user.setName(obj.getName());
        user.setSurname(obj.getSurname());
        user.setRole(obj.getRole());
        return user;
    }

    @Override
    public void delete(Long field) {
        log.info(String.format("%s : method ==> delete(%s)", this.getClass().getName(),field));
        users.remove(field);

    }
}
