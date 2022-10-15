package com.epam.springshop.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Builder
@Data
public class Order {
    long id;
    User user;
    Status status;
    Date orderDate;
   // List<OrderItem> orderItems;
}
