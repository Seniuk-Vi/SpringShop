package com.epam.springshop.service;

import com.epam.springshop.dto.OrderItemDto;
import com.epam.springshop.dto.RoleDto;
import com.epam.springshop.model.OrderItem;

import java.util.List;

public interface OrderItemService {
     OrderItemDto createOrderItem(OrderItemDto obj);
     OrderItemDto getOrderItem(Long obj);
     List<OrderItemDto> getAllOrderItems();
     List<OrderItemDto> getAllOrderItems(long obj);
     OrderItemDto updateOrderItem(Long orderItemId,OrderItemDto obj);
     void deleteOrderItem(Long obj);
}
