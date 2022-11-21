package com.epam.springshop.service.impl;

import com.epam.springshop.dto.OrderItemDto;
import com.epam.springshop.dto.ProductDto;
import com.epam.springshop.exceptions.EntityIllegalArgumentException;
import com.epam.springshop.exceptions.impl.OrderItemNotFoundException;
import com.epam.springshop.exceptions.impl.OrderNotFoundException;
import com.epam.springshop.mapper.OrderItemsMapper;
import com.epam.springshop.mapper.OrderMapper;
import com.epam.springshop.model.Order;
import com.epam.springshop.model.OrderItem;
import com.epam.springshop.repository.OrderItemRepoImpl;
import com.epam.springshop.service.OrderItemService;
import com.epam.springshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepoImpl orderItemRepo;
    private final ProductService productService;

    @Override
    public OrderItemDto createOrderItem(OrderItemDto obj) {
        // check if product exists and if is available
        log.info(String.format("%s : method ==> createOrderItem(%s)", this.getClass().getName(), obj));
        OrderItem orderItem = orderItemRepo.save(OrderItemsMapper.INSTANCE.mapOrderItem(obj));
        return OrderItemsMapper.INSTANCE.mapOrderItemDto(orderItem);
    }

    @Override
    public OrderItemDto getOrderItem(Long obj) {
        log.info(String.format("%s : method ==> getOrderItem(%s)", this.getClass().getName(), obj));
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
        log.info(String.format("%s : method ==> getAllOrderItems(%s)", this.getClass().getName(), obj));
        List<OrderItem> orderItems = new ArrayList<>();
        // todo: specify order id in orderItemRepo
        for (OrderItem order : orderItemRepo.findAll()) {
            if (order.getOrder().getId() == obj) {
                orderItems.add(order);
            }
        }
        return OrderItemsMapper.INSTANCE.mapOrderItemDtos(orderItems);
    }

    @Override
    @Transactional
    public OrderItemDto updateOrderItem(Long orderItemId, OrderItemDto obj) {
        log.info(String.format("%s : method ==> updateOrder(%s)", this.getClass().getName(), obj));
        OrderItem orderItem = orderItemRepo.findById(orderItemId).orElseThrow(OrderItemNotFoundException::new);
        // check field
        ProductDto product = productService.getProduct(orderItem.getProduct().getId());
        // check available quantity
        if (obj.getQuantity() - orderItem.getQuantity() > product.getInStock()) {
            throw new EntityIllegalArgumentException("Can't create order because can't provide available quantity to product: "
                    + product.getTitle());
        }
        // update fields
        orderItem.setQuantity(obj.getQuantity());
        return OrderItemsMapper.INSTANCE.mapOrderItemDto(orderItem);
    }

    @Override
    public void deleteOrderItem(Long obj) {
        log.info(String.format("%s : method ==> deleteOrderItem(%s)", this.getClass().getName(), obj));
        orderItemRepo.deleteById(obj);
    }
}
