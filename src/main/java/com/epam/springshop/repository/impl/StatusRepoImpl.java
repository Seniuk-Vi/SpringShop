package com.epam.springshop.repository.impl;


import com.epam.springshop.model.Status;
import com.epam.springshop.repository.Repo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;
@Slf4j
@Component
public class StatusRepoImpl implements Repo<Status> {
    private final Map<Number, Status> statuses = new HashMap<>();
    long idCounter = 0;

    @Override
    public Status create(Status obj) {
        log.info(String.format("%s : method ==> create(%s)", this.getClass().getName(),obj));
        obj.setId(++idCounter);
        statuses.put(idCounter, obj);
        return obj;
    }

    @Override
    public Status read(Long field) {
        log.info(String.format("%s : method ==> read(%s)", this.getClass().getName(),field));
        return  statuses.get(field);
    }

    @Override
    public List<Status> readAll() {
        log.info(String.format("%s : method ==> readAll()", this.getClass().getName()));
        return new ArrayList<>(statuses.values());
    }

    @Override
    public Status update(Status obj) {
        log.info(String.format("%s : method ==> update()", this.getClass().getName()));
        Status status = read(obj.getId());
        status.setStatus(obj.getStatus());
        return status;
    }

    @Override
    public void delete(Long field) {
        log.info(String.format("%s : method ==> delete(%s)", this.getClass().getName(),field));
        statuses.remove(field);
    }
}
