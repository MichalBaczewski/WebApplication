package com.baczewski.mvc.WebApplication.repository;

import com.baczewski.mvc.WebApplication.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository
        extends CrudRepository<Customer,Integer> {
}
