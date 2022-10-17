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
    Double price;
    String image_url;
    Date post_date;
    Integer in_stock;
    Category category;

}
