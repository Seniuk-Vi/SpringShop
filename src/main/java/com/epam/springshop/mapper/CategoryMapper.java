package com.epam.springshop.mapper;

import com.epam.springshop.dto.CategoryDto;
import com.epam.springshop.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    List<CategoryDto> mapCategoryDtos(List<Category> categories);
    List<Category> mapCategories(List<CategoryDto> categories);

    CategoryDto mapCategoryDto(Category category);


    Category mapCategory(CategoryDto categoryDto);
    Category mapCategoryString(String category);
    CategoryDto mapCategoryDtoString(String category);

}
