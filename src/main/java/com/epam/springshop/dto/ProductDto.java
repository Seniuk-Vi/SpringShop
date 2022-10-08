package com.epam.springshop.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class ProductDto {
    long id;
    String title;
    String description;
    double price;
    String image_url;
    int model_year;
    int in_stock;
    String category;

}
