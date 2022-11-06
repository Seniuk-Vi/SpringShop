package com.epam.springshop.dto;

import com.epam.springshop.dto.group.OnCreate;
import com.epam.springshop.dto.group.OnUpdate;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Builder
@Data
public class OrderItemDto {
    long orderItemId;
    @Positive(groups = OnUpdate.class)
    @NotNull(message = "{orderdto.orderId.notempty}", groups = OnUpdate.class)
    long orderId;
    @Positive
    @NotNull(message = "{orderdto.productId.notempty}", groups = OnCreate.class)
    long productId;
    @Positive
    @NotNull(message = "{orderdto.quantity.notempty}", groups = OnCreate.class)
    int quantity;
}

