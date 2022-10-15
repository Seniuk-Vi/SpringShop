package com.epam.springshop.service.impl;

import com.epam.springshop.dto.ProductDto;
import com.epam.springshop.mapper.ProductMapper;
import com.epam.springshop.model.Product;
import com.epam.springshop.model.User;
import com.epam.springshop.repository.impl.ProductRepoImpl;
import com.epam.springshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepoImpl productRepo;

    @Override
    public ProductDto createProduct(ProductDto obj) {
        Product product=productRepo.create(ProductMapper.INSTANCE.mapProduct(obj));
        return ProductMapper.INSTANCE.mapProductDto(product);
    }

    @Override
    public ProductDto getProduct(Long obj) {
        Product product = productRepo.read(obj);
        return ProductMapper.INSTANCE.mapProductDto(product);
    }

    @Override
    public List<ProductDto> getProducts() {
        List<Product> products = productRepo.readAll();
        return ProductMapper.INSTANCE.mapProductDtos(products);
    }

    @Override
    public ProductDto updateProduct(ProductDto obj) {
        Product product = productRepo.read(obj.getId());
        product.setTitle(obj.getTitle());
        product.setIn_stock(obj.getIn_stock());
        Product product2 = productRepo.update(ProductMapper.INSTANCE.mapProduct(obj));
        return ProductMapper.INSTANCE.mapProductDto(product2);
    }

    @Override
    public void deleteProduct(Long obj) {
        productRepo.delete(obj);
    }
}
