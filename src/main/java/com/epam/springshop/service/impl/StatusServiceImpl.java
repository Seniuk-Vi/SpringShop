package com.epam.springshop.service.impl;

import com.epam.springshop.dto.StatusDto;
import com.epam.springshop.mapper.StatusMapper;
import com.epam.springshop.model.enums.StatusEnum;
import com.epam.springshop.service.StatusService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class StatusServiceImpl implements StatusService {


    @Override
    public StatusDto getStatus(String obj) {
        StatusDto status = null;
        try {
            status = StatusMapper.INSTANCE.statusDtoMapper(StatusEnum.valueOf(obj).toString());
        } catch (IllegalArgumentException ex) {
            log.error(String.format("%s : method ==> getStatus(%s): Exception = %s", this.getClass().getName(), obj, ex));
        }
        return status;
    }

    @Override
    public List<StatusDto> getAllStatuses() {
        StatusEnum[] list = StatusEnum.values();
        List<StatusDto> statusDtos = new ArrayList<>();
        for (StatusEnum statusEnum : list) {
            statusDtos.add(new StatusDto(statusEnum.toString()));
        }
        return statusDtos;
    }
}
