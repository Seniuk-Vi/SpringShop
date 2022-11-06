package com.epam.springshop.mapper;

import com.epam.springshop.dto.RoleDto;
import com.epam.springshop.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
    List<Role> rolesMapper(List<RoleDto> roleDtos);
    List<RoleDto> roleDtosMapper(List<Role> roles);
    Role roleMapper(String role);
    Role roleMapper(RoleDto role);
    RoleDto roleDtoMapper(Role role);

    String roleMapper(Role role);

}
