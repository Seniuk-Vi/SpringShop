package com.epam.springshop.repository.impl;

import com.epam.springshop.model.Category;
import com.epam.springshop.model.Role;
import com.epam.springshop.repository.Repo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class CategoryRepoImpl implements Repo<Category> {
    private final Map<Number, Category> categoryMap = new HashMap<>();
    long idCounter=0;
    @Override
    public Category create(Category obj) {
        obj.setId(++idCounter);
        obj.setCategory(obj.getCategory());
        categoryMap.put(idCounter,obj);
        return obj;
    }

    @Override
    public Category read(Long field) {
        return categoryMap.get(field);
    }

    @Override
    public List<Category> readAll() {
        return (ArrayList<Category>)categoryMap.values();
    }

    @Override
    public Category update(Category obj) {
        Category category = read(obj.getId());
        category.setCategory(obj.getCategory());
        return category;
    }

    @Override
    public void delete(Long field) {

    }
}
