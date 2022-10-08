package com.epam.springshop.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrderItemDto {
    long orderId;
    long productId;
    int quantity;
}

