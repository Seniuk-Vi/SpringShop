package com.epam.springshop.service;

import com.epam.springshop.dto.RoleDto;
import com.epam.springshop.dto.UserDto;

import java.util.List;

public interface RoleService {
     RoleDto createRole(RoleDto obj);
     RoleDto getRole(Long obj);
     List<RoleDto> getAllRoles();
     RoleDto updateRole(RoleDto obj);
     void deleteRole(Long obj);
}
