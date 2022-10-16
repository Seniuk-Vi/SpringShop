package com.epam.springshop.service.impl;

import com.epam.springshop.dto.OrderDto;
import com.epam.springshop.dto.OrderItemDto;
import com.epam.springshop.exceptions.OrderNotFoundException;
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
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepoImpl orderRepo;
    private final OrderItemServiceImpl orderItemService;

    @Override
    public OrderDto createOrder(OrderDto obj) {
        // create order
        log.info(String.format("%s : method ==> createOrder(%s)", this.getClass().getName(),obj));
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
        log.info(String.format("%s : method ==> getOrder(%s)", this.getClass().getName(),obj));
        Order order = orderRepo.read(obj);
        if(order==null){
            throw new OrderNotFoundException();
        }
        List<OrderItemDto> orderItemDtos = orderItemService.getAllOrderItems(order.getId());
        OrderDto orderDto = OrderMapper.INSTANCE.mapOrderDto(order);
        orderDto.setOrderItems(orderItemDtos);
        return orderDto;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        log.info(String.format("%s : method ==> getAllOrders()", this.getClass().getName()));
        List<Order> orders = orderRepo.readAll();
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order : orders) {
            List<OrderItemDto> orderItemDtos = orderItemService.getAllOrderItems(order.getId());
            OrderDto orderDto = OrderMapper.INSTANCE.mapOrderDto(order);
            orderDto.setOrderItems(orderItemDtos);
            orderDtos.add(orderDto);
        }
        return orderDtos;
    }
    @Override
    public List<OrderDto> getAllOrders(Long obj) {
        log.info(String.format("%s : method ==> getAllOrders(%s)", this.getClass().getName(),obj));
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order : orderRepo.readAll()) {
            if(order.getUser().getId()==obj){
                List<OrderItemDto> orderItemDtos = orderItemService.getAllOrderItems(order.getId());
                OrderDto orderDto = OrderMapper.INSTANCE.mapOrderDto(order);
                orderDto.setOrderItems(orderItemDtos);
                orderDtos.add(orderDto);
            }
        }
        return orderDtos;
    }
    @Override
    public OrderDto updateOrder(OrderDto obj) {
        log.info(String.format("%s : method ==> updateOrder(%s)", this.getClass().getName(),obj));
        Order order = orderRepo.update(OrderMapper.INSTANCE.mapOrder(obj));
        // update items
        List<OrderItemDto> orderItems = new ArrayList<>();
        for (OrderItemDto orderItem : obj.getOrderItems()) {
            orderItems.add(orderItemService.updateOrderItem(orderItem));
        }
        OrderDto orderDto = OrderMapper.INSTANCE.mapOrderDto(order);
        orderDto.setOrderItems(orderItems);
        return orderDto;
    }

    @Override
    public void deleteOrder(Long obj) {
        // todo delete order items
        log.info(String.format("%s : method ==> deleteOrder(%s)", this.getClass().getName(),obj));
        orderRepo.delete(obj);
    }
}
