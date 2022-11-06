package com.epam.springshop.mapper;

import com.epam.springshop.dto.RoleDto;
import com.epam.springshop.dto.StatusDto;
import com.epam.springshop.model.Role;
import com.epam.springshop.model.Status;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StatusMapper {
    StatusMapper INSTANCE = Mappers.getMapper(StatusMapper.class);
    List<Status> statusesMapper(List<StatusDto> statusDtos);
    List<StatusDto> statusDtosMapper(List<Status> statuses);
    Status statusMapper(String status);
    Status statusMapper(StatusDto status);
    StatusDto statusDtoMapper(Status status);
    StatusDto statusDtoMapper(String status);

    String statusMapper(Status status);

}
