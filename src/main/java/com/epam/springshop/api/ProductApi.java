package com.epam.springshop.api;

import com.epam.springshop.controller.model.ProductModel;
import com.epam.springshop.controller.model.UserModel;
import com.epam.springshop.dto.ProductDto;
import com.epam.springshop.dto.UserDto;
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

import javax.validation.constraints.NotBlank;
import java.util.List;

@Api(tags = "Product management API")

public interface ProductApi {
    @ApiImplicitParams({@ApiImplicitParam(name = "productDto", paramType = "body", required = true, value = "ProductDto object",dataTypeClass = ProductDto.class)})
    @ApiOperation("Create product for admin")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/admin/products/product")
    ProductModel createProduct(@RequestBody @Validated(OnCreate.class) ProductDto productDto);

    @ApiOperation("Get products")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/products")
    List<ProductDto> getProducts();

    @ApiImplicitParams({@ApiImplicitParam(name = "productId", paramType = "path", required = true, value = "Product id",dataTypeClass = Long.class)})
    @ApiOperation("Get product by id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/products/product/{productId}")
    ProductModel getProduct(@PathVariable @NotBlank Long productId);

    @ApiImplicitParams({@ApiImplicitParam(name = "productId", paramType = "path", required = true, value = "Product id to update",dataTypeClass = Long.class),
            @ApiImplicitParam(name = "productDto", paramType = "body", required = true, value = "ProductDto fields object",dataTypeClass = ProductDto.class)})
    @ApiOperation("Update product for admin")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/admin/products/product/{productId}")
    ProductModel updateProduct(@PathVariable @NotBlank long productId,@RequestBody @Validated(OnUpdate.class) ProductDto productDto);

    @ApiImplicitParams({@ApiImplicitParam(name = "productId", paramType = "path", required = true, value = "Product id",dataTypeClass = Long.class)})
    @ApiOperation("Delete product for admin")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/admin/products/product/{productId}")
    ResponseEntity<Void> deleteProduct(@PathVariable @NotBlank Long productId);


}
