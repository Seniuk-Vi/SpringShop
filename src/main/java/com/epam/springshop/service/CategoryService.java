package com.epam.springshop.service;

import com.epam.springshop.dto.CategoryDto;
import com.epam.springshop.dto.RoleDto;

import java.util.List;

public interface CategoryService {
     CategoryDto createCategory(CategoryDto obj);
     CategoryDto getCategory(Long obj);
     List<CategoryDto> getAllCategories();
     CategoryDto updateCategory(CategoryDto obj);
     void deleteCategory(Long obj);
}