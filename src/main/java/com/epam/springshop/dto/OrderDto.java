package com.epam.springshop.dto;

import com.epam.springshop.model.OrderItem;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Builder
@Data
public class OrderDto {
    long id;
    long user_id;
    long status;
    Date order_date;
    List<OrderItem> orderItems;
}
