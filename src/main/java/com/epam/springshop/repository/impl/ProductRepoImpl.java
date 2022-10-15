package com.epam.springshop.repository.impl;

import com.epam.springshop.dto.CategoryDto;
import com.epam.springshop.mapper.CategoryMapper;
import com.epam.springshop.model.Category;
import com.epam.springshop.model.Product;
import com.epam.springshop.model.User;
import com.epam.springshop.repository.Repo;
import com.epam.springshop.service.CategoryService;
import com.epam.springshop.service.RoleService;
import com.epam.springshop.service.UserService;
import lombok.AllArgsConstructor;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@AllArgsConstructor
public class ProductRepoImpl implements Repo<Product> {

    private final Map<Number,Product> productMap = new HashMap<>();
    private final CategoryService categoryService;

    private static long idCounter=0;
    @Override
    public Product create(Product obj) {
        obj.setId(++idCounter);
        CategoryDto categoryDto = categoryService.createCategory(CategoryMapper.INSTANCE.mapCategoryDto(obj.getCategory()));
        obj.setCategory(CategoryMapper.INSTANCE.mapCategory(categoryDto));
        productMap.put(idCounter,obj);
        return obj;
    }

    @Override
    public Product read(Long field) {
        return productMap.get(field);
    }
    public List<Product> readAll() {
        return  productMap.values().stream().toList();
    }
    @Override
    public Product update(Product obj) {
        Product product = read(obj.getId());
        product.setTitle(obj.getTitle());
        product.setIn_stock(obj.getIn_stock());
        return product;
    }

    @Override
    public void delete(Long field) {
        productMap.remove(field);
    }
}
