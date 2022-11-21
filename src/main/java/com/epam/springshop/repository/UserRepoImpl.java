package com.epam.springshop.repository;

import com.epam.springshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepoImpl extends JpaRepository<User, Long> {
    User findUserByLogin(String login);

    User findUserByEmail(String email);
    User findUserByPhoneNumber(String email);
    @Query("select count(e)>0 from User e where e.email = ?1")
    boolean existsByEmail(String email);
    @Query("select count(e)>0 from User e where e.phoneNumber = ?1")
    boolean existsByPhoneNumber(String phoneNumber);
}
