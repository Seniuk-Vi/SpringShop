package com.epam.springshop.dto;

import com.epam.springshop.exceptions.validator.StatusConstraint;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@StatusConstraint(field = "status")
public class StatusDto {
    String status;

}
