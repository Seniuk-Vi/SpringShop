package com.epam.springshop.repository.impl;

import com.epam.springshop.exceptions.UserNotFoundException;
import com.epam.springshop.model.Role;
import com.epam.springshop.model.Status;
import com.epam.springshop.repository.Repo;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class StatusRepoImpl implements Repo<Status> {
    private final Map<Number, Status> statuses = new HashMap<>();
    long idCounter = 0;

    @Override
    public Status create(Status obj) {
        obj.setId(++idCounter);
        statuses.put(idCounter, obj);
        return obj;
    }

    @Override
    public Status read(Long field) {
        return  statuses.get(field);
    }

    @Override
    public List<Status> readAll() {
        return new ArrayList<>(statuses.values());
    }

    @Override
    public Status update(Status obj) {
        Status status = read(obj.getId());
        status.setStatus(obj.getStatus());
        return status;
    }

    @Override
    public void delete(Long field) {
        statuses.remove(field);
    }
}
