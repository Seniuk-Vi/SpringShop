package com.epam.springshop.service;

import com.epam.springshop.dto.OrderItemDto;
import com.epam.springshop.dto.RoleDto;
import com.epam.springshop.model.OrderItem;

import java.util.List;

public interface OrderItemService {
     OrderItemDto createOrderItem(OrderItemDto obj);
     OrderItemDto getOrderItem(Long obj);
     List<OrderItemDto> getAllOrderItems();
     OrderItemDto updateOrderItem(OrderItemDto obj);
     void deleteOrderItem(Long obj);
}
