package com.epam.springshop.controller.model;

import com.epam.springshop.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class ProductListModel extends RepresentationModel<ProductListModel> {

    @JsonUnwrapped
    private List<ProductDto> productDto;
}
