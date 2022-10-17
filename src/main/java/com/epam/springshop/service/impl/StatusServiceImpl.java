package com.epam.springshop.service.impl;

import com.epam.springshop.dto.RoleDto;
import com.epam.springshop.dto.StatusDto;
import com.epam.springshop.mapper.RoleMapper;
import com.epam.springshop.mapper.StatusMapper;
import com.epam.springshop.model.Role;
import com.epam.springshop.model.Status;
import com.epam.springshop.repository.impl.RoleRepoImpl;
import com.epam.springshop.repository.impl.StatusRepoImpl;
import com.epam.springshop.service.RoleService;
import com.epam.springshop.service.StatusService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
@Slf4j
@Component
@RequiredArgsConstructor
public class StatusServiceImpl implements StatusService {
    private final StatusRepoImpl statusRepo;


    @Override
    public StatusDto createStatus(StatusDto obj) {
        log.info(String.format("%s : method ==> createStatus(%s)", this.getClass().getName(),obj));
        Status status = statusRepo.create(StatusMapper.INSTANCE.statusMapper(obj));
        return StatusMapper.INSTANCE.statusDtoMapper(status);
    }

    @Override
    public StatusDto getStatus(Long obj) {
        log.info(String.format("%s : method ==> getStatus(%s)", this.getClass().getName(),obj));
        return StatusMapper.INSTANCE.statusDtoMapper(statusRepo.read(obj));
    }

    @Override
    public List<StatusDto> getAllStatuses() {
        log.info(String.format("%s : method ==> getAllStatuses()", this.getClass().getName()));
        return StatusMapper.INSTANCE.statusDtosMapper(statusRepo.readAll());
    }

    @Override
    public StatusDto updateStatus(StatusDto obj) {
        log.info(String.format("%s : method ==> updateStatus(%s)", this.getClass().getName(),obj));
        Status status = statusRepo.update(StatusMapper.INSTANCE.statusMapper(obj));
        return StatusMapper.INSTANCE.statusDtoMapper(status);
    }

    @Override
    public void deleteStatus(Long obj) {
        log.info(String.format("%s : method ==> deleteStatus(%s)", this.getClass().getName(),obj));
        statusRepo.delete(obj);
    }
}
