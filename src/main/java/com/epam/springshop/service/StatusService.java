package com.epam.springshop.service;

import com.epam.springshop.dto.RoleDto;
import com.epam.springshop.dto.StatusDto;

import java.util.List;

public interface StatusService {
     StatusDto createStatus(StatusDto obj);
     StatusDto getStatus(Long obj);
     List<StatusDto> getAllStatuses();
     StatusDto updateStatus(StatusDto obj);
     void deleteStatus(Long obj);
}
