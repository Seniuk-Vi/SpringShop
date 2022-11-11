package com.epam.springshop.service.impl;

import com.epam.springshop.dto.OrderItemDto;
import com.epam.springshop.exceptions.OrderNotFoundException;
import com.epam.springshop.mapper.OrderItemsMapper;
import com.epam.springshop.model.OrderItem;
import com.epam.springshop.repository.OrderItemRepoImpl;
import com.epam.springshop.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepoImpl orderItemRepo;

    @Override
    public OrderItemDto createOrderItem(OrderItemDto obj) {
        // check if product exists and if is available
        log.info(String.format("%s : method ==> createOrderItem(%s)", this.getClass().getName(),obj));
        OrderItem orderItem = orderItemRepo.save(OrderItemsMapper.INSTANCE.mapOrderItem(obj));
        return OrderItemsMapper.INSTANCE.mapOrderItemDto(orderItem);
    }

    @Override
    public OrderItemDto getOrderItem(Long obj) {
        log.info(String.format("%s : method ==> getOrderItem(%s)", this.getClass().getName(),obj));
        OrderItem orderItem = orderItemRepo.findById(obj).orElseThrow(OrderNotFoundException::new);
        return OrderItemsMapper.INSTANCE.mapOrderItemDto(orderItem);
    }

    @Override
    public List<OrderItemDto> getAllOrderItems() {
        log.info(String.format("%s : method ==> OrderItemDto()", this.getClass().getName()));
        List<OrderItem> orderItems = orderItemRepo.findAll();
        return OrderItemsMapper.INSTANCE.mapOrderItemDtos(orderItems);
    }
    @Override
    public List<OrderItemDto> getAllOrderItems(long obj) {
        log.info(String.format("%s : method ==> getAllOrderItems(%s)", this.getClass().getName(),obj));
        List<OrderItem> orderItems = new ArrayList<>();
        // todo: specify order id in orderItemRepo
        for (OrderItem order : orderItemRepo.findAll()) {
            if(order.getOrder().getId()==obj){
                orderItems.add(order);
            }
        }
        return OrderItemsMapper.INSTANCE.mapOrderItemDtos(orderItems);
    }
    @Override
    public OrderItemDto updateOrderItem(OrderItemDto obj) {
        return null;
//        log.info(String.format("%s : method ==> updateOrderItem(%s)", this.getClass().getName(),obj));
//        OrderItem orderItem = orderItemRepo.update(OrderItemsMapper.INSTANCE.mapOrderItem(obj));
//        return OrderItemsMapper.INSTANCE.mapOrderItemDto(orderItem);
        }

    @Override
    public void deleteOrderItem(Long obj) {
        log.info(String.format("%s : method ==> deleteOrderItem(%s)", this.getClass().getName(),obj));
        orderItemRepo.deleteById(obj);
    }
}
