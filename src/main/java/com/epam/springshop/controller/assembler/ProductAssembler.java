package com.epam.springshop.controller.assembler;

import com.epam.springshop.controller.ProductController;
import com.epam.springshop.controller.UserController;
import com.epam.springshop.controller.model.ProductModel;
import com.epam.springshop.controller.model.UserModel;
import com.epam.springshop.dto.ProductDto;
import com.epam.springshop.dto.UserDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProductAssembler extends RepresentationModelAssemblerSupport<ProductDto,ProductModel> {
    public static final String GET_REL = "get_product";
    public static final String GET_ALL_REL = "get_all_products";
    public static final String CREATE_REL = "create_product";
    public static final String PUT_REL = "put_product";
    public static final String DELETE_REL = "delete_product";

    public ProductAssembler() {
        super(ProductController.class, ProductModel.class);
    }

    @Override
    public ProductModel toModel(ProductDto entity) {
        ProductModel productModel= new ProductModel(entity);
        Link get = linkTo(methodOn(ProductController.class).getProduct(entity.getId())).withRel(GET_REL);
        Link getUsers = linkTo(methodOn(ProductController.class).getProducts()).withRel(GET_ALL_REL);
        Link create = linkTo(methodOn(ProductController.class).createProduct(entity)).withRel(CREATE_REL);
        Link update= linkTo(methodOn(ProductController.class).updateProduct(entity)).withRel(PUT_REL);
        Link delete= linkTo(methodOn(ProductController.class).deleteProduct(entity.getId())).withRel(DELETE_REL);
        productModel.add(get,getUsers,create,update,delete);
        return productModel;
    }
}
