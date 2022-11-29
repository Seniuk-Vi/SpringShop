package com.epam.springshop.repository;

import static com.epam.springshop.utils.TestUtils.*;

import com.epam.springshop.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = DEFINED_PORT)
@ActiveProfiles("test")
@Sql("classpath:sql/user-data.sql")
@Transactional
class UserRepoImplTest {
    @Autowired
    private UserRepoImpl userRepo;

    @Test
    void findUserByLogin() {
        //given
        User user = getUser();
        //when
        User newUser = userRepo.findUserByLogin(USER_LOGIN);
        //then
        System.out.println(newUser);
        System.out.println(user);
        assertEquals(user,newUser);
    }

    @Test
    void findUserByEmail() {
        //given
        User user = getUser();
        //when
        User newUser = userRepo.findUserByEmail(USER_EMAIL);
        //then
        assertEquals(user,newUser);
    }

    @Test
    void findUserByPhoneNumber() {
        //given
        User user = getUser();
        //when
        User newUser = userRepo.findUserByPhoneNumber(USER_PHONE_NUMBER);
        //then
        assertEquals(user,newUser);
    }

    @Test
    void existsByEmail() {
        //given
        User user = getUser();
        //when
        boolean existsByEmail = userRepo.existsByEmail(USER_EMAIL);
        //then
        assertTrue(existsByEmail);
    }

    @Test
    void existsByPhoneNumber() {
        //given
        User user = getUser();
        //when
        boolean existsByEmail = userRepo.existsByPhoneNumber(USER_PHONE_NUMBER);
        //then
        assertTrue(existsByEmail);
    }
}