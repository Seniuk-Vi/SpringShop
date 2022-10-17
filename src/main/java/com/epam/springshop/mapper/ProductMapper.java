package com.epam.springshop.mapper;

import com.epam.springshop.dto.ProductDto;
import com.epam.springshop.dto.UserDto;
import com.epam.springshop.model.Category;
import com.epam.springshop.model.Product;
import com.epam.springshop.model.Role;
import com.epam.springshop.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    List<ProductDto> mapProductDtos(List<Product> products);

    @Mappings(@Mapping(source = "category.category",target = "category"))
    ProductDto mapProductDto(Product product);

    Product mapProduct(ProductDto productDto);

    default Category mapCategory(String category) {
        return CategoryMapper.INSTANCE.mapCategoryString(category);
    }
}
