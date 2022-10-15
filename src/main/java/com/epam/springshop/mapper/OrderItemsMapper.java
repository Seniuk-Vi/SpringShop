package com.epam.springshop.mapper;

import com.epam.springshop.dto.OrderItemDto;
import com.epam.springshop.model.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper

public interface OrderItemsMapper {

    OrderItemsMapper INSTANCE = Mappers.getMapper(OrderItemsMapper.class);

    List<OrderItem> mapOrderItems(List<OrderItemDto> orderItemDtos);

    List<OrderItemDto> mapOrderItemDtos(List<OrderItem> orderItems);

    @Mappings({@Mapping(source = "product.id", target = "productId"),
             @Mapping(source = "order.id", target = "orderId")})
    OrderItemDto mapOrderItemDto(OrderItem orderItem);

    OrderItem mapOrderItem(OrderItemDto orderItemDto);

}
