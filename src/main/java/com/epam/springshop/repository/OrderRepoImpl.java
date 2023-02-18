package com.epam.springshop.repository;

import com.epam.springshop.model.Order;
import com.epam.springshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepoImpl extends JpaRepository<Order,Long> {
        List<Order> findAllByUser(User user);
}
