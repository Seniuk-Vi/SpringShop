package com.epam.springshop.repository.impl;

import com.epam.springshop.model.Order;
import com.epam.springshop.model.enums.StatusEnum;
import com.epam.springshop.repository.Repo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@Component
public class OrderRepoImpl implements Repo<Order> {
    private final Map<Number, Order> orders = new HashMap<>();
    long idCounter = 0;

    @Override
    public Order create(Order obj) {
        log.info(String.format("%s : method ==> create(%s)", this.getClass().getName(),obj));
        obj.setId(++idCounter);
        obj.setStatus(StatusEnum.CREATED);
        orders.put(idCounter, obj);
        return obj;
    }

    @Override
    public Order read(Long field) {
        log.info(String.format("%s : method ==> read(%s)", this.getClass().getName(),field));
        return orders.get(field);
    }

    @Override
    public List<Order> readAll() {
        log.info(String.format("%s : method ==> readAll()", this.getClass().getName()));
        return new ArrayList<>(orders.values());
    }

    @Override
    public Order update(Order obj) {
        log.info(String.format("%s : method ==> update(%s)", this.getClass().getName(),obj));
        Order order = read(obj.getId());
        order.setStatus(obj.getStatus());
        return order;
    }

    @Override
    public void delete(Long field) {
        log.info(String.format("%s : method ==> delete(%s)", this.getClass().getName(),field));
        orders.remove(field);
    }
}
