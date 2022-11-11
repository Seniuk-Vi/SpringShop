package com.epam.springshop.repository;

import com.epam.springshop.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepoImpl extends JpaRepository<Role,Long> {

}