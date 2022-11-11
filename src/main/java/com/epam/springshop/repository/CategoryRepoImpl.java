package com.epam.springshop.repository;

import com.epam.springshop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepoImpl extends JpaRepository<Category,Long> {

}
