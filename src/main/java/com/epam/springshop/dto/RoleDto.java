package com.epam.springshop.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RoleDto {
    private long id;
    String role;

}
