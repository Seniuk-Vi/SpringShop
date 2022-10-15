package com.epam.springshop.service.impl;

import com.epam.springshop.dto.OrderDto;
import com.epam.springshop.dto.OrderItemDto;
import com.epam.springshop.mapper.OrderMapper;
import com.epam.springshop.mapper.UserMapper;
import com.epam.springshop.model.Order;
import com.epam.springshop.model.OrderItem;
import com.epam.springshop.model.User;
import com.epam.springshop.repository.impl.OrderItemRepoImpl;
import com.epam.springshop.repository.impl.OrderRepoImpl;
import com.epam.springshop.service.OrderItemService;
import com.epam.springshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepoImpl orderRepo;
    private final OrderItemServiceImpl orderItemService;

    @Override
    public OrderDto createOrder(OrderDto obj) {
        // create order
        Order order = orderRepo.create(OrderMapper.INSTANCE.mapOrder(obj));
        // todo check if status exists

        // create orderitems
        List<OrderItemDto> orderItems = new ArrayList<>();
        for (OrderItemDto orderItem : obj.getOrderItems()) {
            orderItem.setOrderId(order.getId());
            orderItems.add(orderItemService.createOrderItem(orderItem));
        }
        // create orderDto
        OrderDto orderDto = OrderMapper.INSTANCE.mapOrderDto(order);
        orderDto.setOrderItems(orderItems);
        return orderDto;
    }

    @Override
    public OrderDto getOrder(Long obj) {
        Order order = orderRepo.read(obj);
        return OrderMapper.INSTANCE.mapOrderDto(order);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepo.readAll();
        return OrderMapper.INSTANCE.mapOrderDtos(orders);
    }

    @Override
    public OrderDto updateOrder(OrderDto obj) {
        Order order = orderRepo.update(OrderMapper.INSTANCE.mapOrder(obj));
        return OrderMapper.INSTANCE.mapOrderDto(order);
    }

    @Override
    public void deleteOrder(Long obj) {
        orderRepo.delete(obj);
    }
}
