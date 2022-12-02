package com.epam.springshop.api;

import com.epam.springshop.dto.ProductDto;
import com.epam.springshop.dto.group.OnCreate;
import com.epam.springshop.dto.group.OnUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@Api(tags = "Rest template products")
@RequestMapping("/template")
public interface RestTemplateApi {
    @ApiImplicitParams({@ApiImplicitParam(name = "productDto", paramType = "body", required = true, value = "ProductDto object",dataTypeClass = ProductDto.class)})
    @ApiOperation("Create product for admin(template)")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/products")
    JSONObject createProduct(@RequestBody @Validated(OnCreate.class) ProductDto productDto);

    @ApiOperation("Get products(template)")
    @GetMapping("/products")
    String getProducts();

    @ApiImplicitParams({@ApiImplicitParam(name = "productId", paramType = "path", required = true, value = "Product id",dataTypeClass = Long.class)})
    @ApiOperation("Get product by id(template)")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/product/{productId}")
    JSONObject getProduct(@PathVariable @NotBlank Long productId);

    @ApiImplicitParams({@ApiImplicitParam(name = "productId", paramType = "path", required = true, value = "Product id to update",dataTypeClass = Long.class),
            @ApiImplicitParam(name = "productDto", paramType = "body", required = true, value = "ProductDto fields object",dataTypeClass = ProductDto.class)})
    @ApiOperation("Update product for admin")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/products/{productId}")
    JSONObject updateProduct(@PathVariable @NotBlank long productId, @RequestBody @Validated(OnUpdate.class) ProductDto productDto);

    @ApiImplicitParams({@ApiImplicitParam(name = "productId", paramType = "path", required = true, value = "Product id",dataTypeClass = Long.class)})
    @ApiOperation("Delete product for admin")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/products/{productId}")
    JSONObject deleteProduct(@PathVariable @NotBlank Long productId);


}
