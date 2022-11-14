package com.epam.springshop.service.impl;

import com.epam.springshop.dto.OrderDto;
import com.epam.springshop.dto.OrderItemDto;
import com.epam.springshop.exceptions.OrderNotFoundException;
import com.epam.springshop.mapper.OrderMapper;
import com.epam.springshop.model.Order;
import com.epam.springshop.model.OrderItem;
import com.epam.springshop.model.Product;
import com.epam.springshop.repository.OrderRepoImpl;
import com.epam.springshop.service.OrderItemService;
import com.epam.springshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderRepoImpl orderRepo;
    private final OrderItemService orderItemService;

    @Override
    public OrderDto createOrder(OrderDto obj) {
        // create order
        log.info(String.format("%s : method ==> createOrder(%s)", this.getClass().getName(), obj));
        obj.setStatus("CREATED");
        Order order = OrderMapper.INSTANCE.mapOrder(obj);
        System.out.println(order);
        order = orderRepo.save(order);
        // todo check if status exists
        // create orderItems
        List<OrderItemDto> orderItems = new ArrayList<>();
        for (OrderItem orderItem : order.getOrderItems()) {
            orderItem.setOrder(order);
          //  orderItem.setProduct(Product.builder().id(1).build());
        }
        return getOrder(order.getId());
    }

    @Override
    public OrderDto getOrder(Long obj) {
        log.info(String.format("%s : method ==> getOrder(%s)", this.getClass().getName(), obj));
        Order order = orderRepo.findById(obj).orElseThrow(OrderNotFoundException::new);
        if (order == null) {
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
        List<Order> orders = orderRepo.findAll();
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
        log.info(String.format("%s : method ==> getAllOrders(%s)", this.getClass().getName(), obj));
        List<OrderDto> orderDtos = new ArrayList<>();
        // todo: specify find with userId
        for (Order order : orderRepo.findAll()) {
            if (order.getUser().getId() == obj) {
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
        return null;
//        log.info(String.format("%s : method ==> updateOrder(%s)", this.getClass().getName(), obj));
//        Order order = orderRepo.update(OrderMapper.INSTANCE.mapOrder(obj));
//        // update items
//        List<OrderItemDto> orderItems = new ArrayList<>();
//        for (OrderItemDto orderItem : obj.getOrderItems()) {
//            orderItems.add(orderItemService.updateOrderItem(orderItem));
//        }
//        OrderDto orderDto = OrderMapper.INSTANCE.mapOrderDto(order);
//        orderDto.setOrderItems(orderItems);
//        return orderDto;
    }

    @Override
    public void deleteOrder(Long obj) {
        // todo delete order items
        log.info(String.format("%s : method ==> deleteOrder(%s)", this.getClass().getName(), obj));
        orderRepo.deleteById(obj);
    }
}
