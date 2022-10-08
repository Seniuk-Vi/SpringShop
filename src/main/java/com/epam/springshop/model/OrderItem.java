package com.epam.springshop.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrderItem {
    long orderId;
    long productId;
    int quantity;
}

