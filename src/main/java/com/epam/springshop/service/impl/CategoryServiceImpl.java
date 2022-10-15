package com.epam.springshop.service.impl;

import com.epam.springshop.dto.CategoryDto;
import com.epam.springshop.dto.RoleDto;
import com.epam.springshop.mapper.CategoryMapper;
import com.epam.springshop.mapper.UserMapper;
import com.epam.springshop.model.Category;
import com.epam.springshop.model.User;
import com.epam.springshop.repository.impl.CategoryRepoImpl;
import com.epam.springshop.repository.impl.RoleRepoImpl;
import com.epam.springshop.service.CategoryService;
import com.epam.springshop.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepoImpl categoryRepo;

    @Override
    public CategoryDto createCategory(CategoryDto obj) {
        Category category = categoryRepo.create(CategoryMapper.INSTANCE.mapCategory(obj));
        return CategoryMapper.INSTANCE.mapCategoryDto(category);
    }

    @Override
    public CategoryDto getCategory(Long obj) {
        return CategoryMapper.INSTANCE.mapCategoryDto(categoryRepo.read(obj));
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return CategoryMapper.INSTANCE.mapCategoryDtos(categoryRepo.readAll());
    }

    @Override
    public CategoryDto updateCategory(CategoryDto obj) {
        Category category = categoryRepo.update(CategoryMapper.INSTANCE.mapCategory(obj));
        return CategoryMapper.INSTANCE.mapCategoryDto(category);
    }

    @Override
    public void deleteCategory(Long obj) {
        categoryRepo.delete(obj);
    }
}
