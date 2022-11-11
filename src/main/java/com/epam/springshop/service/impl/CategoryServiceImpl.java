package com.epam.springshop.service.impl;

import com.epam.springshop.dto.CategoryDto;
import com.epam.springshop.exceptions.UserNotFoundException;
import com.epam.springshop.mapper.CategoryMapper;
import com.epam.springshop.model.Category;
import com.epam.springshop.model.User;
import com.epam.springshop.repository.CategoryRepoImpl;
import com.epam.springshop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepoImpl categoryRepo;

    @Override
    public CategoryDto createCategory(CategoryDto obj) {
        log.info(String.format("%s : method ==> createCategory(%s)", this.getClass().getName(), obj));
        Category category = categoryRepo.save(CategoryMapper.INSTANCE.mapCategory(obj));
        return CategoryMapper.INSTANCE.mapCategoryDto(category);
    }

    @Override
    public CategoryDto getCategory(Long obj) {
        log.info(String.format("%s : method ==> CategoryDto(%s)", this.getClass().getName(), obj));
        Category category = categoryRepo.findById(obj).orElseThrow(UserNotFoundException::new);
        if (category == null) {
            throw new UserNotFoundException();
        }
        return CategoryMapper.INSTANCE.mapCategoryDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        log.info(String.format("%s : method ==> getAllCategories()", this.getClass().getName()));
        return CategoryMapper.INSTANCE.mapCategoryDtos(categoryRepo.findAll());
    }

    @Override
    public CategoryDto updateCategory(CategoryDto obj) {
        return null;
//        log.info(String.format("%s : method ==> updateCategory(%s)", this.getClass().getName(), obj));
//        Category category = categoryRepo.update(CategoryMapper.INSTANCE.mapCategory(obj));
//        return CategoryMapper.INSTANCE.mapCategoryDto(category);
    }

    @Override
    public void deleteCategory(Long obj) {
        log.info(String.format("%s : method ==> deleteCategory(%s)", this.getClass().getName(), obj));
        categoryRepo.deleteById(obj);
    }
}
