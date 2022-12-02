package com.epam.springshop.repository;

import com.epam.springshop.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepoImpl extends PagingAndSortingRepository<Product,Long> {
}
