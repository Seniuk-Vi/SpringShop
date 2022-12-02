package com.epam.springshop.dto;

import com.epam.springshop.dto.group.OnCreate;
import com.epam.springshop.dto.group.OnUpdate;
import com.epam.springshop.exceptions.validator.PatternConstraint;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {
    @Positive(groups = OnUpdate.class)
    long id;
    @NotBlank(message = "{productdto.title.notempty}", groups = {OnUpdate.class,OnCreate.class})
    String title;
    @NotBlank(message = "{productdto.description.notempty}", groups = {OnCreate.class,OnUpdate.class})
    String description;
    @NotNull(message = "{productdto.price.notempty}", groups = {OnCreate.class, OnUpdate.class})
    Double price;
    @NotBlank(message = "{productdto.imageurl.notempty}", groups = OnCreate.class)
    String imageUrl;
    @NotNull(message = "{productdto.postdate.notempty}", groups = OnCreate.class)
    @PatternConstraint(message = "{productdto.postdate.wrongformat}",pattern = "^[0-9]{4}-[0-9]{2}-[0-9]{2}")
    String postDate;
    @NotNull(message = "{productdto.instock.notempty}", groups = {OnCreate.class,OnUpdate.class})
    Integer inStock;
    @NotBlank(message = "{productdto.category.notempty}", groups = OnCreate.class)
    String category;

}
