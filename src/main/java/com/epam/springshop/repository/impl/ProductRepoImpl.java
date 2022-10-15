package com.epam.springshop.repository.impl;

import com.epam.springshop.model.Category;
import com.epam.springshop.model.Product;
import com.epam.springshop.model.User;
import com.epam.springshop.repository.Repo;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductRepoImpl implements Repo<Product> {

    private final Map<Number,Product> productMap = new HashMap<>();
    Repo<Category> categoryRepo = new CategoryRepoImpl(); // better make roleService
    long idCounter=0;
    @Override
    public Product create(Product obj) {
        obj.setId(++idCounter);
        obj.setCategory(categoryRepo.create(obj.getCategory()));
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
        product = obj;
        return product;
    }

    @Override
    public void delete(Long field) {
        productMap.remove(field);
    }
}
