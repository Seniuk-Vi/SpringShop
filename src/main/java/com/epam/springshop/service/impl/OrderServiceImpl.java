package com.epam.springshop.service.impl;

import com.epam.springshop.dto.OrderDto;
import com.epam.springshop.dto.OrderItemDto;
import com.epam.springshop.dto.ProductDto;
import com.epam.springshop.dto.UserDto;
import com.epam.springshop.exceptions.EntityIllegalArgumentException;
import com.epam.springshop.exceptions.impl.OrderNotFoundException;
import com.epam.springshop.exceptions.impl.ProductNotFoundException;
import com.epam.springshop.exceptions.impl.UserNotFoundException;
import com.epam.springshop.mapper.OrderMapper;
import com.epam.springshop.mapper.UserMapper;
import com.epam.springshop.model.Order;
import com.epam.springshop.model.OrderItem;
import com.epam.springshop.model.enums.StatusEnum;
import com.epam.springshop.repository.OrderRepoImpl;
import com.epam.springshop.service.OrderItemService;
import com.epam.springshop.service.OrderService;
import com.epam.springshop.service.ProductService;
import com.epam.springshop.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderRepoImpl orderRepo;
    private final OrderItemService orderItemService;
    private final UserService userService;
    private final ProductService productService;

    @Override
    @Transactional
    public OrderDto createOrder(OrderDto obj) {
        // create order
        log.info(String.format("%s : method ==> createOrder(%s)", this.getClass().getName(), obj));
        Order order = OrderMapper.INSTANCE.mapOrder(obj);
        // check fields
        List<EntityIllegalArgumentException> exceptions = new ArrayList<>();
        // check if user exists
        try{
            userService.getUser(obj.getUserId());
        }catch (UserNotFoundException ex){
            exceptions.add( new EntityIllegalArgumentException(ex.getMessage()));
        }
        // check date
        Date date = new Date();
        if (order.getOrderDate().after(date)) {
            exceptions.add(new EntityIllegalArgumentException("Order date can't be in future"));
        }
        // check if all products exists
        for (OrderItemDto orderItem : obj.getOrderItems()) {
            try{
                productService.getProduct(orderItem.getProductId());
            }catch (ProductNotFoundException ex){
                exceptions.add( new EntityIllegalArgumentException(ex.getMessage()));
            }
        }

        if (exceptions.size() > 0) {
            String messages = exceptions.toString();
            throw new EntityIllegalArgumentException(messages);
        }
        // set default values
        order.setStatus(StatusEnum.CREATED);
        // save
        order = orderRepo.save(order);
        // todo check if status exists
        // set order id to orderItems
        for (OrderItem orderItem : order.getOrderItems()) {
            ProductDto product = productService.getProduct(orderItem.getProduct().getId());
            // check available quantity
            if (orderItem.getQuantity()>product.getInStock()){
                exceptions.add(new EntityIllegalArgumentException("Can't create order because can't provide available quantity to product: "+product.getTitle()));
            }
            product.setInStock(product.getInStock()-orderItem.getQuantity());
            orderItem.setOrder(order);
        }
        if (exceptions.size() > 0) {
            String messages = exceptions.toString();
            throw new EntityIllegalArgumentException(messages);
        }
        return getOrder(order.getId());
    }

    @Override
    public OrderDto getOrder(Long obj) {
        log.info(String.format("%s : method ==> getOrder(%s)", this.getClass().getName(), obj));
        Order order = orderRepo.findById(obj).orElseThrow(OrderNotFoundException::new);
        OrderDto orderDto = OrderMapper.INSTANCE.mapOrderDto(order);
        return orderDto;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        log.info(String.format("%s : method ==> getAllOrders()", this.getClass().getName()));
        List<Order> orders = orderRepo.findAll();
        List<OrderDto> orderDtos = OrderMapper.INSTANCE.mapOrderDtos(orders);
        return orderDtos;
    }

    @Override
    public List<OrderDto> getAllOrders(Long obj) {
        log.info(String.format("%s : method ==> getAllOrders(%s)", this.getClass().getName(), obj));
        UserDto user = userService.getUser(obj);
        List<Order> orders = orderRepo.findAllByUser(UserMapper.INSTANCE.mapUser(user));
        List<OrderDto> orderDtos = OrderMapper.INSTANCE.mapOrderDtos(orders);
        return orderDtos;
    }

    @Override
    @Transactional
    public OrderDto updateOrder(Long orderId, OrderDto obj) {
        log.info(String.format("%s : method ==> updateOrder(%s)", this.getClass().getName(), obj));
        Order order = orderRepo.findById(orderId).orElseThrow(ProductNotFoundException::new);
        // todo: check field

        // update fields
        Order upd_order = OrderMapper.INSTANCE.mapOrder(obj);
        order.setStatus(upd_order.getStatus());

        return OrderMapper.INSTANCE.mapOrderDto(order);
    }

    @Override
    public void deleteOrder(Long obj) {
        // todo delete order items
        log.info(String.format("%s : method ==> deleteOrder(%s)", this.getClass().getName(), obj));
        orderRepo.deleteById(obj);
    }
}
