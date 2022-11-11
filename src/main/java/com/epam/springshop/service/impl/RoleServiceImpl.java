package com.epam.springshop.service.impl;

import com.epam.springshop.dto.RoleDto;
import com.epam.springshop.exceptions.RoleNotFoundException;
import com.epam.springshop.mapper.RoleMapper;
import com.epam.springshop.model.Role;
import com.epam.springshop.repository.RoleRepoImpl;
import com.epam.springshop.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepoImpl roleRepo;


    @Override
    public RoleDto createRole(RoleDto obj) {
        log.info(String.format("%s : method ==> createRole(%s)", this.getClass().getName(),obj));
        Role role = roleRepo.save(RoleMapper.INSTANCE.roleMapper(obj));
        return RoleMapper.INSTANCE.roleDtoMapper(role);
    }

    @Override
    public RoleDto getRole(Long obj) {
        log.info(String.format("%s : method ==> getRole(%s)", this.getClass().getName(),obj));
        return RoleMapper.INSTANCE.roleDtoMapper(roleRepo.findById(obj).orElseThrow(RoleNotFoundException::new));
    }

    @Override
    public RoleDto getRole(String obj) {
        log.info(String.format("%s : method ==> getRole(%s)", this.getClass().getName(),obj));
        // todo: specify normally
        for (Role role : roleRepo.findAll()) {
            if (role.getRole().equals(obj)){
                return RoleMapper.INSTANCE.roleDtoMapper(role);
            }
        }
        return null;
    }

    @Override
    public List<RoleDto> getAllRoles() {
        log.info(String.format("%s : method ==> getAllRoles()", this.getClass().getName()));
        return RoleMapper.INSTANCE.roleDtosMapper(roleRepo.findAll());
    }

    @Override
    public RoleDto updateRole(RoleDto obj) {
        return null;
//        log.info(String.format("%s : method ==> updateRole(%s)", this.getClass().getName(),obj));
//        Role role = roleRepo.update(RoleMapper.INSTANCE.roleMapper(obj));
//        return RoleMapper.INSTANCE.roleDtoMapper(role);
    }

    @Override
    public void deleteRole(Long obj) {
        log.info(String.format("%s : method ==> deleteRole(%s)", this.getClass().getName(),obj));
        roleRepo.deleteById(obj);
    }
}
