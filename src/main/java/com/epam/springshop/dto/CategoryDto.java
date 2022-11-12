package com.epam.springshop.dto;

import com.epam.springshop.dto.group.OnCreate;
import com.epam.springshop.dto.group.OnUpdate;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CategoryDto {
    long id;
    @NotNull(groups = {OnCreate.class, OnUpdate.class})
    String category;
}
