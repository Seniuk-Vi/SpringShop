package com.epam.springshop.repository;

import com.epam.springshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepoImpl extends JpaRepository<User, Long> {

}
