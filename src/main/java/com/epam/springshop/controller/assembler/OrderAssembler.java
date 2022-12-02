package com.epam.springshop.controller.assembler;

import com.epam.springshop.controller.OrderController;
import com.epam.springshop.controller.model.OrderModel;
import com.epam.springshop.dto.OrderDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class OrderAssembler extends RepresentationModelAssemblerSupport<OrderDto, OrderModel> {
    public static final String GET_REL = "get_order";
    public static final String GET_ALL_REL = "get_all_orders";
    public static final String CREATE_REL = "create_order";
    public static final String PUT_REL = "put_order";
    public static final String DELETE_REL = "delete_order";

    public OrderAssembler() {
        super(OrderController.class, OrderModel.class);
    }

    @Override
    public OrderModel toModel(OrderDto entity) {
        OrderModel orderModel = new OrderModel(entity);
        Link get = linkTo(methodOn(OrderController.class).getOrder(entity.getUserId(), entity.getId())).withRel(GET_REL);
        Link getUsers = linkTo(methodOn(OrderController.class).getOrders(entity.getUserId())).withRel(GET_ALL_REL);
        Link create = linkTo(methodOn(OrderController.class).createOrder(entity.getUserId(),entity)).withRel(CREATE_REL);
        Link update = linkTo(methodOn(OrderController.class).updateOrder(entity.getUserId(),entity.getId(), entity)).withRel(PUT_REL);
        Link delete = linkTo(methodOn(OrderController.class).deleteOrder(entity.getUserId(), entity.getId())).withRel(DELETE_REL);
        orderModel.add(get, getUsers, create, update, delete);
        return orderModel;
    }
}
