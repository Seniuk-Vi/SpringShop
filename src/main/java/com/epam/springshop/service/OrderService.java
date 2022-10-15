package com.epam.springshop.service;

import com.epam.springshop.dto.OrderDto;
import com.epam.springshop.dto.OrderItemDto;

import java.util.List;

public interface OrderService {
    OrderDto createOrder(OrderDto obj);
    OrderDto getOrder(Long obj);
    List<OrderDto> getAllOrders();
    OrderDto updateOrder(OrderDto obj);
    void deleteOrder(Long obj);
}
