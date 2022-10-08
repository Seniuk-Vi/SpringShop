package com.epam.springshop.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class Product {
    long id;
    String title;
    String description;
    double price;
    String image_url;
    Date model_year;
    int in_stock;
    Category category;

}
