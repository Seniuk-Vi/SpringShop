package com.epam.springshop.service;

import com.epam.springshop.dto.ProductDto;
import com.epam.springshop.dto.UserDto;

import java.util.List;

public interface ProductService {

     ProductDto createProduct(ProductDto obj);
     ProductDto getProduct(Long obj);
     List<ProductDto> getProducts();
     ProductDto updateProduct(ProductDto obj);
     void deleteProduct(Long obj);
}
