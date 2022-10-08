package com.epam.springshop.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Category {
    long id;
    String categoryName;
}
