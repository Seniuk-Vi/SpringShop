package com.epam.springshop.dto;

import com.epam.springshop.dto.group.OnCreate;
import com.epam.springshop.dto.group.OnUpdate;
import com.epam.springshop.exceptions.validator.PatternConstraint;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDto {
    long id;
    @Positive
    @NotNull(message = "{orderdto.userId.notempty}", groups = OnCreate.class)
    long userId;
    @NotBlank(message = "{orderdto.status.notempty}", groups = OnUpdate.class)
    String status;
    @NotNull(message = "{orderdto.orderDate.notempty}", groups = OnCreate.class)
    @PatternConstraint(message = "{orderdto.orderDate.wrongformat}", pattern = "^[0-9]{4}-[0-9]{2}-[0-9]{2}")
    String orderDate;
    @NotNull(message = "{orderdto.orderItems.notempty}", groups = OnCreate.class)
    List<OrderItemDto> orderItems;
}
