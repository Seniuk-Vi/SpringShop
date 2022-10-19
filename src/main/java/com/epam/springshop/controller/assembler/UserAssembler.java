package com.epam.springshop.controller.assembler;

import com.epam.springshop.controller.UserController;
import com.epam.springshop.controller.model.UserModel;
import com.epam.springshop.dto.UserDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserAssembler extends RepresentationModelAssemblerSupport<UserDto, UserModel> {
    public static final String GET_REL = "get_user";
    public static final String GET_ALL_REL = "get_all_users";
    public static final String CREATE_REL = "create_user";
    public static final String PUT_REL = "put_user";
    public static final String DELETE_REL = "delete_user";

    public UserAssembler() {
        super(UserController.class, UserModel.class);
    }

    @Override
    public UserModel toModel(UserDto entity) {
        UserModel userModel= new UserModel(entity);
        Link get = linkTo(methodOn(UserController.class).getUser(entity.getId())).withRel(GET_REL);
        Link getUsers = linkTo(methodOn(UserController.class).getUsers()).withRel(GET_ALL_REL);
        Link create = linkTo(methodOn(UserController.class).createUser(entity)).withRel(CREATE_REL);
        Link update= linkTo(methodOn(UserController.class).updateUser(entity.getId(),entity)).withRel(PUT_REL);
        Link delete= linkTo(methodOn(UserController.class).deleteUser(entity.getId())).withRel(DELETE_REL);
        userModel.add(get,getUsers,create,update,delete);
        return userModel;
    }
}
