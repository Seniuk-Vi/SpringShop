package com.epam.springshop.controller;

import com.epam.springshop.api.OrderApi;
import com.epam.springshop.controller.assembler.OrderAssembler;
import com.epam.springshop.controller.model.OrderModel;
import com.epam.springshop.dto.OrderDto;
import com.epam.springshop.dto.UserDto;
import com.epam.springshop.exceptions.EntityIllegalArgumentException;
import com.epam.springshop.service.OrderService;
import com.epam.springshop.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor

public class OrderController implements OrderApi {
    private final OrderService orderService;
    private final UserService userService;
    private final OrderAssembler orderAssembler;

    @Override
    public OrderModel createOrder( long userId,OrderDto orderDto) {
        // todo check if order has appropriate userId
        log.info(String.format("%s : method ==> createOrder(%s)", this.getClass().getName(), orderDto));
        OrderDto order =  orderService.createOrder(orderDto);
        return orderAssembler.toModel(order);

    }

    @Override
    public List<OrderDto> getOrders(Long userId) {
        log.info(String.format("%s : method ==> getOrders(%s)", this.getClass().getName(), userId));
        return orderService.getAllOrders(userId);
    }
    @Override
    public OrderModel getOrder( long userId,Long orderId) {
        // todo check if order has appropriate userId
        log.info(String.format("%s : method ==> getOrder(%s)", this.getClass().getName(),orderId));
        OrderDto order =   orderService.getOrder(orderId);
        return orderAssembler.toModel(order);

    }
    @Override
    public OrderModel updateOrder( long userId,long orderId,OrderDto orderDto) {
        // todo check if order has appropriate userId
        log.info(String.format("%s : method ==> updateOrder(%s)", this.getClass().getName(), orderDto));
        // check if user exists
        UserDto user = userService.getUser(userId);
        OrderDto orderDto2 = orderService.getOrder(orderId);
        // check if this order
        if(orderDto2.getUserId()!=userId){
            throw new EntityIllegalArgumentException("User don't have order with this id");
        }
        // update order
        OrderDto order =  orderService.updateOrder(orderId,orderDto);
        return orderAssembler.toModel(order);
    }

    @Override
    public ResponseEntity<Void> deleteOrder( long userId, Long orderId) {
        // todo check if order has appropriate userId
        log.info(String.format("%s : method ==> deleteOrder(%s)", this.getClass().getName(), orderId));
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok().build();
    }
}
