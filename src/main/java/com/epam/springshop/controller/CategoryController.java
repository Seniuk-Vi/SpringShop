package com.epam.springshop.controller;

import com.epam.springshop.api.CategoryApi;
import com.epam.springshop.api.UserApi;
import com.epam.springshop.controller.assembler.UserAssembler;
import com.epam.springshop.controller.model.UserModel;
import com.epam.springshop.dto.CategoryDto;
import com.epam.springshop.dto.UserDto;
import com.epam.springshop.service.CategoryService;
import com.epam.springshop.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CategoryController implements CategoryApi {

    private final CategoryService categoryService;


    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        log.info(this.getClass() + ": method ==> createCategory");
        CategoryDto category = categoryService.createCategory(categoryDto);
        return category;
    }

    @Override
    public CategoryDto getCategory(long categoryId) {
        log.info(String.format("%s : method ==> getCategory(%s)", this.getClass().getName(), categoryId));
        CategoryDto category = categoryService.getCategory(categoryId);
        return category;
    }

    @Override
    public List<CategoryDto> getCategories() {
        log.info(String.format("%s : method ==> getCategories()", this.getClass().getName()));
        return categoryService.getAllCategories();
    }

    @Override
    public CategoryDto updateCategory(long categoryId, CategoryDto categoryDto) {
        log.info(String.format("%s : method ==> updateCategory(%s, %s)", this.getClass().getName(),categoryId ,categoryDto));
        CategoryDto category = categoryService.updateCategory(categoryId,categoryDto);
        return category;

    }


    @Override
    public ResponseEntity<Void> deleteCategory(long categoryId) {
        log.info(String.format("%s : method ==> deleteCategory(%s)", this.getClass().getName(), categoryId));
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok().build();
    }

}
