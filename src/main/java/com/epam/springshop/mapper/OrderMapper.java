package com.epam.springshop.mapper;

import com.epam.springshop.dto.OrderDto;
import com.epam.springshop.dto.OrderItemDto;
import com.epam.springshop.exceptions.ProductException;
import com.epam.springshop.model.Order;
import com.epam.springshop.model.OrderItem;
import com.epam.springshop.model.Status;
import com.epam.springshop.model.User;
import com.epam.springshop.model.enums.StatusEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Mapper

public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    List<Order> mapOrders(List<OrderDto> orderDtos);

    List<OrderDto> mapOrderDtos(List<Order> orders);

    @Mappings({@Mapping(source = "user.id", target = "userId")})
    OrderDto mapOrderDto(Order order);
    @Mappings({@Mapping(source = "userId", target = "user")})
    Order mapOrder(OrderDto orderDto);

    default User mapUser(long userId) {
        return User.builder().id(userId).build();
    }
    OrderItem mapOrderItem(OrderItemDto orderItemDto);
    default Date mapDate(String stringDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = format.parse(stringDate);
            return date;
        } catch (ParseException e) {
            throw new ProductException(); // todo: can't user message source here
        }
    }

    default String mapDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String stringDate = format.format(date);
        return stringDate;
    }
}
