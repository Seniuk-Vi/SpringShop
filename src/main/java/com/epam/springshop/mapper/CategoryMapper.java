package com.epam.springshop.mapper;

import com.epam.springshop.dto.CategoryDto;
import com.epam.springshop.dto.ProductDto;
import com.epam.springshop.model.Category;
import com.epam.springshop.model.Product;
import com.epam.springshop.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    List<CategoryDto> mapCategoryDtos(List<Category> categories);

    CategoryDto mapCategoryDto(Category category);


    Category mapCategory(CategoryDto categoryDto);
    Category mapCategoryString(String category);

}
