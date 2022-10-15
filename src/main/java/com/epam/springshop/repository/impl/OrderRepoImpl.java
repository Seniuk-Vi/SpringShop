package com.epam.springshop.repository.impl;

import com.epam.springshop.exceptions.UserNotFoundException;
import com.epam.springshop.model.Order;
import com.epam.springshop.model.Role;
import com.epam.springshop.repository.Repo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class OrderRepoImpl implements Repo<Order> {
    private final Map<Number, Order> orders = new HashMap<>();
    long idCounter = 0;

    @Override
    public Order create(Order obj) {
        obj.setId(++idCounter);
        orders.put(idCounter, obj);
        return obj;
    }

    @Override
    public Order read(Long field) {
        Order order = orders.get(field);
        if (order == null) {
            throw new UserNotFoundException();
        }
        return order;
    }

    @Override
    public List<Order> readAll() {
        return new ArrayList<>(orders.values());
    }

    @Override
    public Order update(Order obj) {
        Order order = read(obj.getId());
        order.setStatus(obj.getStatus());
        return order;
    }

    @Override
    public void delete(Long field) {
        orders.remove(field);
    }
}
