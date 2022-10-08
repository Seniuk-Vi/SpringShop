package com.epam.springshop.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Builder
@Data
public class Order {
    long id;
    long user_id;
    long status;
    Date order_date;
    List<OrderItem> orderItems;
}