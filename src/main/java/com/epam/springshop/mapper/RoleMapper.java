package com.epam.springshop.mapper;

import com.epam.springshop.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    Role roleMapper(String role);

    String roleMapper(Role role);

}
