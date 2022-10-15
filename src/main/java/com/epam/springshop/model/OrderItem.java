package com.epam.springshop.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrderItem {
    long OrderItemId;   // better to make orderId and ProductId primary and for. keys
    Order order;
    Product product;
    int quantity;
}

