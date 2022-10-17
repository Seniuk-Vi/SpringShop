package com.epam.springshop.dto;

import com.epam.springshop.dto.group.OnCreate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {
    long id;
    @NotBlank(message = "'title' shouldn't be empty", groups = OnCreate.class)
    String title;
    @NotBlank(message = "'description' shouldn't be empty", groups = OnCreate.class)
    String description;
    @NotNull(message = "'price' shouldn't be empty", groups = OnCreate.class)
    Double price;
  //  @NotBlank(message = "'image_url' shouldn't be empty", groups = OnCreate.class)
    String image_url;
    @NotNull(message = "'post date' shouldn't be empty", groups = OnCreate.class)
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date post_date;
    @NotNull(message = "'in stock' shouldn't be empty", groups = OnCreate.class)
    Integer in_stock;
    @NotBlank(message = "'category' shouldn't be empty", groups = OnCreate.class)
    String category;

}
