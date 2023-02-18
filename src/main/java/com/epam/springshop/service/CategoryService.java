package com.epam.springshop.service;

import com.epam.springshop.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
     CategoryDto createCategory(CategoryDto obj);
     CategoryDto getCategory(Long obj);
     CategoryDto getCategory(String obj);
     List<CategoryDto> getAllCategories();
     CategoryDto updateCategory(Long id,CategoryDto obj);
     void deleteCategory(Long obj);
}
