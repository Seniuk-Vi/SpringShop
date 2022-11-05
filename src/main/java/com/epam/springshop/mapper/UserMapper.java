package com.epam.springshop.mapper;

import com.epam.springshop.dto.UserDto;
import com.epam.springshop.model.Role;
import com.epam.springshop.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    List<UserDto> mapUserDtos(List<User> users);
    @Mappings(@Mapping(source = "role.role", target = "role"))
    UserDto mapUserDto(User user);


    User mapUser(UserDto userDto);

    default Role mapRole(String role) {
        return RoleMapper.INSTANCE.roleMapper(role);
    }

}
