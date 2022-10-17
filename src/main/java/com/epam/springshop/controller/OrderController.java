package com.epam.springshop.controller;

import com.epam.springshop.controller.assembler.OrderAssembler;
import com.epam.springshop.controller.model.OrderModel;
import com.epam.springshop.dto.OrderDto;
import com.epam.springshop.dto.ProductDto;
import com.epam.springshop.dto.group.OnCreate;
import com.epam.springshop.service.OrderService;
import com.epam.springshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor

public class OrderController {
    private final OrderService orderService;
    private final OrderAssembler orderAssembler;

    @PostMapping("/{userId}/order")
    public OrderModel createOrder(@RequestBody @Validated(OnCreate.class) OrderDto orderDto) {
        log.info(String.format("%s : method ==> createProduct(%s)", this.getClass().getName(), orderDto));
        OrderDto order =  orderService.createOrder(orderDto);
        return orderAssembler.toModel(order);

    }

    @GetMapping("/{userId}/order")
    public List<OrderDto> getOrders(@PathVariable Long userId) {
        log.info(String.format("%s : method ==> getOrders(%s)", this.getClass().getName(), userId));
        return orderService.getAllOrders(userId);
    }
    @GetMapping("/{userId}/order/{orderId}")
    public OrderModel getOrder(@PathVariable Long orderId) {
        log.info(String.format("%s : method ==> getOrder(%s)", this.getClass().getName(),orderId));
        OrderDto order =   orderService.getOrder(orderId);
        return orderAssembler.toModel(order);

    }
    @PutMapping("/{userId}/order/{orderId}")
    public OrderModel updateOrder(@RequestBody @Validated(OnCreate.class) OrderDto orderDto) {
        log.info(String.format("%s : method ==> updateProduct(%s)", this.getClass().getName(), orderDto));
        OrderDto order =  orderService.updateOrder(orderDto);
        return orderAssembler.toModel(order);
    }

    @DeleteMapping("/{userId}/order/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        log.info(String.format("%s : method ==> deleteProduct(%s)", this.getClass().getName(), orderId));
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok().build();
    }
}
