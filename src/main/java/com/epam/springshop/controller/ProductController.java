package com.epam.springshop.controller;

import com.epam.springshop.dto.ProductDto;
import com.epam.springshop.dto.group.OnCreate;
import com.epam.springshop.dto.group.OnUpdate;
import com.epam.springshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor

public class ProductController {
    private final ProductService productService;

    @PostMapping("/product")
    public ProductDto createProduct(@RequestBody @Validated(OnCreate.class) ProductDto productDto) {
        log.info(String.format("%s : method ==> createProduct(%s)", this.getClass().getName(), productDto));
        return productService.createProduct(productDto);

    }

    @GetMapping
    public List<ProductDto> getProducts() {
        log.info(String.format("%s : method ==> getProducts()", this.getClass().getName()));
        return productService.getProducts();
    }
    @GetMapping("/product/{productId}")
    public ProductDto getProduct(@PathVariable @NotBlank Long productId) {
        log.info(String.format("%s : method ==> getProduct()", this.getClass().getName()));
        return productService.getProduct(productId);
    }
    @PutMapping("/product/{productId}")
    public ProductDto updateProduct(@RequestBody @Validated(OnUpdate.class) ProductDto productDto) {
        log.info(String.format("%s : method ==> updateProduct(%s)", this.getClass().getName(), productDto));
        return productService.updateProduct(productDto);
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable @NotBlank Long productId) {
        log.info(String.format("%s : method ==> updateProduct(%s)", this.getClass().getName(), productId));
        productService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }
}
