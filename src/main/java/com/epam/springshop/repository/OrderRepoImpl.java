package com.epam.springshop.repository;

import com.epam.springshop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepoImpl extends JpaRepository<Order,Long> {

}
