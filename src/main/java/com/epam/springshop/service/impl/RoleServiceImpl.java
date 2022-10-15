package com.epam.springshop.service.impl;

import com.epam.springshop.dto.RoleDto;
import com.epam.springshop.mapper.RoleMapper;
import com.epam.springshop.mapper.UserMapper;
import com.epam.springshop.model.Role;
import com.epam.springshop.model.User;
import com.epam.springshop.repository.impl.RoleRepoImpl;
import com.epam.springshop.repository.impl.UserRepoImpl;
import com.epam.springshop.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepoImpl roleRepo;


    @Override
    public RoleDto createRole(RoleDto obj) {
        Role role = roleRepo.create(RoleMapper.INSTANCE.roleMapper(obj));
        return RoleMapper.INSTANCE.roleDtoMapper(role);
    }

    @Override
    public RoleDto getRole(Long obj) {
        return RoleMapper.INSTANCE.roleDtoMapper(roleRepo.read(obj));
    }

    @Override
    public List<RoleDto> getAllRoles() {
        return RoleMapper.INSTANCE.roleDtosMapper(roleRepo.readAll());
    }

    @Override
    public RoleDto updateRole(RoleDto obj) {
        Role role = roleRepo.update(RoleMapper.INSTANCE.roleMapper(obj));
        return RoleMapper.INSTANCE.roleDtoMapper(role);
    }

    @Override
    public void deleteRole(Long obj) {
        roleRepo.delete(obj);
    }
}
