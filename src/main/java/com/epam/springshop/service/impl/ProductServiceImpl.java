package com.epam.springshop.service.impl;

import com.epam.springshop.dto.ProductDto;
import com.epam.springshop.exceptions.ProductNotFoundException;
import com.epam.springshop.exceptions.UserNotFoundException;
import com.epam.springshop.mapper.ProductMapper;
import com.epam.springshop.model.Product;
import com.epam.springshop.model.User;
import com.epam.springshop.repository.impl.ProductRepoImpl;
import com.epam.springshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepoImpl productRepo;

    @Override
    public ProductDto createProduct(ProductDto obj) {
        // todo check if category exists
        log.info(String.format("%s : method ==> createProduct(%s)", this.getClass().getName(),obj));
        Product product=productRepo.create(ProductMapper.INSTANCE.mapProduct(obj));
        return ProductMapper.INSTANCE.mapProductDto(product);
    }

    @Override
    public ProductDto getProduct(Long obj) {
        log.info(String.format("%s : method ==> getProduct(%s)", this.getClass().getName(),obj));
        Product product = productRepo.read(obj);
        if(product == null){
            throw new ProductNotFoundException();
        }
        return ProductMapper.INSTANCE.mapProductDto(product);
    }

    @Override
    public List<ProductDto> getProducts() {
        log.info(String.format("%s : method ==> getProducts()", this.getClass().getName()));
        List<Product> products = productRepo.readAll();
        return ProductMapper.INSTANCE.mapProductDtos(products);
    }

    @Override
    public ProductDto updateProduct(ProductDto obj) {
        log.info(String.format("%s : method ==> updateProduct(%s)", this.getClass().getName(),obj));
        Product product2 = productRepo.update(ProductMapper.INSTANCE.mapProduct(obj));
        return ProductMapper.INSTANCE.mapProductDto(product2);
    }

    @Override
    public void deleteProduct(Long obj) {
        log.info(String.format("%s : method ==> deleteProduct(%s)", this.getClass().getName(),obj));
        productRepo.delete(obj);
    }
}
