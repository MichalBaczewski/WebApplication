package com.baczewski.mvc.WebApplication.repository;

import com.baczewski.mvc.WebApplication.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
