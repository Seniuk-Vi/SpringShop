package com.epam.springshop.controller;

import com.epam.springshop.dto.ProductDto;
import com.epam.springshop.dto.UserDto;
import com.epam.springshop.service.ProductService;
import com.epam.springshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor

public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto){
        System.out.println(productDto);
        return productService.createProduct(productDto);

    }
    @GetMapping
    public List<ProductDto> getProducts(){
        return productService.getProducts();
    }

}
