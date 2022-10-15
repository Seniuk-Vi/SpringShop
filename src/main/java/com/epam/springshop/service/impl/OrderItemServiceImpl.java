package com.epam.springshop.service.impl;

import com.epam.springshop.dto.OrderItemDto;
import com.epam.springshop.mapper.OrderItemsMapper;
import com.epam.springshop.model.OrderItem;
import com.epam.springshop.repository.impl.CategoryRepoImpl;
import com.epam.springshop.repository.impl.OrderItemRepoImpl;
import com.epam.springshop.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepoImpl orderItemRepo;

    @Override
    public OrderItemDto createOrderItem(OrderItemDto obj) {
        OrderItem orderItem = orderItemRepo.create(OrderItemsMapper.INSTANCE.mapOrderItem(obj));
        return OrderItemsMapper.INSTANCE.mapOrderItemDto(orderItem);
    }

    @Override
    public OrderItemDto getOrderItem(Long obj) {
        OrderItem orderItem = orderItemRepo.read(obj);
        return OrderItemsMapper.INSTANCE.mapOrderItemDto(orderItem);
    }

    @Override
    public List<OrderItemDto> getAllOrderItems() {
        List<OrderItem> orderItems = orderItemRepo.readAll();
        return OrderItemsMapper.INSTANCE.mapOrderItemDtos(orderItems);
    }

    @Override
    public OrderItemDto updateOrderItem(OrderItemDto obj) {
        OrderItem orderItem = orderItemRepo.update(OrderItemsMapper.INSTANCE.mapOrderItem(obj));
        return OrderItemsMapper.INSTANCE.mapOrderItemDto(orderItem);    }

    @Override
    public void deleteOrderItem(Long obj) {
        orderItemRepo.delete(obj);
    }
}
