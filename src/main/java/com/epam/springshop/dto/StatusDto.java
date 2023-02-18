package com.epam.springshop.dto;

import com.epam.springshop.exceptions.validator.StatusConstraint;
import lombok.*;

@Builder
@Data
@Setter
@Getter
@AllArgsConstructor
@StatusConstraint(field = "status")
public class StatusDto {
    private String status;
}
