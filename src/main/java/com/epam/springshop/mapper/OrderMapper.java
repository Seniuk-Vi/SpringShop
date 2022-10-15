package com.epam.springshop.mapper;

import com.epam.springshop.dto.OrderDto;
import com.epam.springshop.dto.OrderItemDto;
import com.epam.springshop.model.Order;
import com.epam.springshop.model.OrderItem;
import com.epam.springshop.model.Status;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper

public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    List<Order> mapOrders(List<OrderDto> orderDtos);

    List<OrderDto> mapOrderDtos(List<Order> orders);

    @Mappings({@Mapping(source = "user.id", target = "userId"),
            @Mapping(source = "status.status", target = "status")})
    OrderDto mapOrderDto(Order order);

    Order mapOrder(OrderDto orderDto);

    default Status mapStatus(String status) {
        return StatusMapper.INSTANCE.statusMapper(status);
    }

    OrderItem mapOrderItem(OrderItemDto orderItemDto);
}
