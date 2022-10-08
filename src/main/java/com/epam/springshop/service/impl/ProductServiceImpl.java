package com.epam.springshop.service.impl;

import com.epam.springshop.dto.ProductDto;
import com.epam.springshop.model.Category;
import com.epam.springshop.model.Product;
import com.epam.springshop.repository.impl.ProductRepoImpl;
import com.epam.springshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepoImpl productRepo;

    @Override
    public ProductDto createProduct(ProductDto obj) {
        Integer value = obj.getModel_year();
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy");
        Date date; // your date
// Choose time zone in which you want to interpret your Date
        Calendar cal = Calendar.getInstance();

        try {
            System.out.println(originalFormat.parse(value.toString()));
        Product product = productRepo.create(Product.builder()
                .category(Category.builder().categoryName(obj.getCategory()).build())
                .description(obj.getDescription())
                .image_url(obj.getImage_url())
                .title(obj.getTitle())
                .in_stock(obj.getIn_stock())
                .model_year(originalFormat.parse(value.toString()))
                .price(obj.getPrice())
                .build());
            cal.setTime(product.getModel_year());
        return ProductDto.builder()
                .id(product.getId())
                .category(product.getCategory().getCategoryName())
                .description(product.getDescription())
                .image_url(product.getImage_url())
                .title(product.getTitle())
                .in_stock(product.getIn_stock())
                .model_year(cal.get(Calendar.YEAR))    //?
                .price(product.getPrice())
                .build();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ProductDto getProduct(Long obj) {
        Product product = productRepo.read(obj);
        return ProductDto.builder()
                .category(product.getCategory().getCategoryName())
                .description(product.getDescription())
                .image_url(product.getImage_url())
                .title(product.getTitle())
                .in_stock(product.getIn_stock())
                .model_year((int) product.getModel_year().getTime())    //?
                .price(product.getPrice())
                .build();
    }

    @Override
    public List<ProductDto> getProducts() {
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : productRepo.readAll()) { // better with stream
            productDtos.add(ProductDto.builder()
                            .id(product.getId())
                    .category(product.getCategory().getCategoryName())
                    .description(product.getDescription())
                    .image_url(product.getImage_url())
                    .title(product.getTitle())
                    .in_stock(product.getIn_stock())
                    .model_year((int) product.getModel_year().getTime())    //?
                    .price(product.getPrice())
                    .build());
        }
        return productDtos;
    }

    @Override
    public ProductDto updateProduct(ProductDto obj) {
        return null;
    }

    @Override
    public void deleteProduct(Long obj) {

    }
}
