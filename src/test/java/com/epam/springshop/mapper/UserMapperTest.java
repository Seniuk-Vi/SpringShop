package com.epam.springshop.mapper;

import com.epam.springshop.dto.UserDto;
import com.epam.springshop.model.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.epam.springshop.utils.TestUtils.*;
import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    @Test
    void mapUserDtos() {
        //given
        List<User> users = List.of(getUser(), getUser());
        //when
        List<UserDto> userDtos = UserMapper.INSTANCE.mapUserDtos(users);
        //then
        userDtos.forEach(
                userDto -> {
                    assertEquals(USER_ID, userDto.getId());
                    assertEquals(USER_LOGIN, userDto.getLogin());
                    assertEquals(USER_NAME, userDto.getName());
                    assertEquals(USER_SURNAME, userDto.getSurname());
                    assertEquals(USER_PHONE_NUMBER, userDto.getPhoneNumber());
                    assertEquals(USER_EMAIL, userDto.getEmail());
                    assertEquals(USER_LOCALE, userDto.getLocale());
                    assertEquals(USER_DTO_ROLE, userDto.getRole());
                    assertEquals(USER_PASSWORD, userDto.getPassword());
                }
        );
    }

    @Test
    void mapUserDto() {
        //given
        UserDto userDto = getUserDto();
        //when
        User user = UserMapper.INSTANCE.mapUser(userDto);
        //then
        assertEquals(USER_DTO_ID, user.getId());
        assertEquals(USER_DTO_LOGIN, user.getLogin());
        assertEquals(USER_DTO_NAME, user.getName());
        assertEquals(USER_DTO_SURNAME, user.getSurname());
        assertEquals(USER_DTO_PHONE_NUMBER, user.getPhoneNumber());
        assertEquals(USER_DTO_EMAIL, user.getEmail());
        assertEquals(USER_DTO_LOCALE, user.getLocale());
        assertEquals(USER_ROLE, user.getRole());
        assertEquals(USER_DTO_PASSWORD, user.getPassword());
    }

    @Test
    void mapUser() {
        //given
        User user = getUser();
        //when
        UserDto userDto = UserMapper.INSTANCE.mapUserDto(user);
        //then
        assertEquals(USER_ID, userDto.getId());
        assertEquals(USER_LOGIN, userDto.getLogin());
        assertEquals(USER_NAME, userDto.getName());
        assertEquals(USER_SURNAME, userDto.getSurname());
        assertEquals(USER_PHONE_NUMBER, userDto.getPhoneNumber());
        assertEquals(USER_EMAIL, userDto.getEmail());
        assertEquals(USER_LOCALE, userDto.getLocale());
        assertEquals(USER_DTO_ROLE, userDto.getRole());
        assertEquals(USER_PASSWORD, userDto.getPassword());

    }
}