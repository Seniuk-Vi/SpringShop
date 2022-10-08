package com.epam.springshop.service;

import com.epam.springshop.dto.ProductDto;
import com.epam.springshop.dto.UserDto;

import java.util.List;

public interface ProductService {

    public ProductDto createProduct(ProductDto obj);
    public ProductDto getProduct(Long obj);
    public List<ProductDto> getProducts();
    public ProductDto updateProduct(ProductDto obj);
    public void deleteProduct(Long obj);
}
