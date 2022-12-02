package com.epam.springshop.api;

import com.epam.springshop.controller.model.OrderModel;
import com.epam.springshop.dto.OrderDto;
import com.epam.springshop.dto.group.OnCreate;
import com.epam.springshop.dto.group.OnUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Order management API")

public interface OrderApi {
    @ApiImplicitParams({@ApiImplicitParam(name = "orderDto", paramType = "body", required = true, value = "Order object", dataTypeClass = OrderDto.class)})
    @ApiOperation("Create order")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/user/{userId}/order")
    OrderModel createOrder(@PathVariable long userId, @RequestBody @Validated(OnCreate.class) OrderDto orderDto);
    @ApiImplicitParams({@ApiImplicitParam(name = "userId", paramType = "path", required = true, value = "User id", dataTypeClass = Long.class)})
    @ApiOperation("Get user orders")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user/{userId}/order")
    List<OrderDto> getOrders(@PathVariable Long userId);

    @ApiImplicitParams({@ApiImplicitParam(name = "userId", paramType = "path", required = true, value = "User id", dataTypeClass = Long.class),
            @ApiImplicitParam(name = "orderId", paramType = "path", required = true, value = "Order id", dataTypeClass = Long.class)})
    @ApiOperation("Get order by id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user/{userId}/order/{orderId}")
    OrderModel getOrder(@PathVariable long userId, @PathVariable Long orderId);

    @ApiImplicitParams({@ApiImplicitParam(name = "userId", paramType = "path", required = true, value = "User id", dataTypeClass = Long.class),
            @ApiImplicitParam(name = "orderId", paramType = "path", required = true, value = "Order id to update", dataTypeClass = Long.class),
            @ApiImplicitParam(name = "orderDto", paramType = "body", required = true, value = "OrderDto to update (status = [CREATED,PAYED, FINISHED])", dataTypeClass = OrderDto.class)})
    @ApiOperation("Update order")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/user/{userId}/order/{orderId}")
    OrderModel updateOrder(@PathVariable long userId, @PathVariable long orderId, @RequestBody @Validated(OnUpdate.class) OrderDto orderDto);

    @ApiImplicitParams({@ApiImplicitParam(name = "userId", paramType = "path", required = true, value = "User id", dataTypeClass = Long.class),
            @ApiImplicitParam(name = "orderId", paramType = "path", required = true, value = "Order id to delete", dataTypeClass = Long.class)})
    @ApiOperation("Delete order")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/user/{userId}/order/{orderId}")
    ResponseEntity<Void> deleteOrder(@PathVariable long userId, @PathVariable Long orderId);


}
