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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Slf4j
@Component
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepoImpl roleRepo;


    @Override
    public RoleDto createRole(RoleDto obj) {
        log.info(String.format("%s : method ==> createRole(%s)", this.getClass().getName(),obj));
        Role role = roleRepo.create(RoleMapper.INSTANCE.roleMapper(obj));
        return RoleMapper.INSTANCE.roleDtoMapper(role);
    }

    @Override
    public RoleDto getRole(Long obj) {
        log.info(String.format("%s : method ==> getRole(%s)", this.getClass().getName(),obj));
        return RoleMapper.INSTANCE.roleDtoMapper(roleRepo.read(obj));
    }

    @Override
    public List<RoleDto> getAllRoles() {
        log.info(String.format("%s : method ==> getAllRoles()", this.getClass().getName()));
        return RoleMapper.INSTANCE.roleDtosMapper(roleRepo.readAll());
    }

    @Override
    public RoleDto updateRole(RoleDto obj) {
        log.info(String.format("%s : method ==> updateRole(%s)", this.getClass().getName(),obj));
        Role role = roleRepo.update(RoleMapper.INSTANCE.roleMapper(obj));
        return RoleMapper.INSTANCE.roleDtoMapper(role);
    }

    @Override
    public void deleteRole(Long obj) {
        log.info(String.format("%s : method ==> deleteRole(%s)", this.getClass().getName(),obj));
        roleRepo.delete(obj);
    }
}
