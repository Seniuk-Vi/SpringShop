package com.epam.springshop.repository.impl;

import com.epam.springshop.exceptions.UserNotFoundException;
import com.epam.springshop.model.Order;
import com.epam.springshop.model.OrderItem;
import com.epam.springshop.repository.Repo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@Component
public class OrderItemRepoImpl implements Repo<OrderItem> {

    private final Map<Number, OrderItem> orderItems = new HashMap<>();

    long idCounter = 0;

    @Override
    public OrderItem create(OrderItem obj) {
        log.info(String.format("%s : method ==> create(%s)", this.getClass().getName(),obj));
        obj.setOrderItemId(++idCounter);
        orderItems.put(idCounter, obj);
        return obj;
    }

    @Override
    public OrderItem read(Long field) {
        log.info(String.format("%s : method ==> read(%s)", this.getClass().getName(),field));
        OrderItem order = orderItems.get(field);
        if (order == null) {
            throw new UserNotFoundException();
        }
        return order;
    }

    public OrderItem readWithOrderAndProduct(Long orderId, Long productId) {
        log.info(String.format("%s : method ==> readWithOrderAndProduct(%s,%s)", this.getClass().getName(),orderId,productId));
        OrderItem order = null;
        for (OrderItem value : (orderItems.values())) {
            if (value.getOrder().getId() == orderId && value.getProduct().getId() == productId) {
                order = value;
                break;
            }
        }
        return order;
    }

    @Override
    public List<OrderItem> readAll() {
        log.info(String.format("%s : method ==> readAll()", this.getClass().getName()));
        return new ArrayList<>(orderItems.values());
    }

    @Override
    public OrderItem update(OrderItem obj) {
        log.info(String.format("%s : method ==> update(%s)", this.getClass().getName(),obj));
        OrderItem order = read(obj.getOrder().getId());
        order.setQuantity(obj.getQuantity());
        return order;
    }

    @Override
    public void delete(Long field) {
        log.info(String.format("%s : method ==> delete(%s)", this.getClass().getName(),field));
        orderItems.remove(field);
    }
}
