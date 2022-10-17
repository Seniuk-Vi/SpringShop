package com.epam.springshop.controller;

import com.epam.springshop.controller.assembler.ProductAssembler;
import com.epam.springshop.controller.model.ProductModel;
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
    private final ProductAssembler productAssembler;

    @PostMapping("/product")
    public ProductModel createProduct(@RequestBody @Validated(OnCreate.class) ProductDto productDto) {
        log.info(String.format("%s : method ==> createProduct(%s)", this.getClass().getName(), productDto));
        ProductDto product= productService.createProduct(productDto);
        return productAssembler.toModel(product);
    }

    @GetMapping
    public List<ProductDto> getProducts() {
        log.info(String.format("%s : method ==> getProducts()", this.getClass().getName()));
        return productService.getProducts();
    }
    @GetMapping("/product/{productId}")
    public ProductModel getProduct(@PathVariable @NotBlank Long productId) {
        log.info(String.format("%s : method ==> getProduct()", this.getClass().getName()));
        ProductDto product=productService.getProduct(productId);
        return productAssembler.toModel(product);
    }
    @PutMapping("/product/{productId}")
    public ProductModel updateProduct(@RequestBody @Validated(OnUpdate.class) ProductDto productDto) {
        log.info(String.format("%s : method ==> updateProduct(%s)", this.getClass().getName(), productDto));
        ProductDto product= productService.updateProduct(productDto);
        return productAssembler.toModel(product);
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable @NotBlank Long productId) {
        log.info(String.format("%s : method ==> updateProduct(%s)", this.getClass().getName(), productId));
        productService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }
}
