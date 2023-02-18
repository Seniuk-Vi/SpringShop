package com.epam.springshop.repository;

import com.epam.springshop.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepoImpl extends JpaRepository<OrderItem,Long> {

}
