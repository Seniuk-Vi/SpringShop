package com.epam.springshop.service;

import com.epam.springshop.dto.RoleDto;
import com.epam.springshop.dto.StatusDto;

import java.util.List;

public interface StatusService {
    StatusDto getStatus(String obj);
    List<StatusDto> getAllStatuses();

}