package com.epam.springshop.mapper;

import com.epam.springshop.dto.ProductDto;
import com.epam.springshop.exceptions.ProductException;
import com.epam.springshop.model.Category;
import com.epam.springshop.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    List<ProductDto> mapProductDtos(List<Product> products);

    @Mappings(@Mapping(source = "category.category", target = "category"))
    ProductDto mapProductDto(Product product);

    Product mapProduct(ProductDto productDto);

    default Category mapCategory(String category) {
        return CategoryMapper.INSTANCE.mapCategoryString(category);
    }

    default Date mapDate(String stringDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = format.parse(stringDate);
            return date;
        } catch (ParseException e) {
            throw new ProductException(); // todo: can't user message source here
        }
    }

    default String mapDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String stringDate = format.format(date);
        return stringDate;
    }
}
