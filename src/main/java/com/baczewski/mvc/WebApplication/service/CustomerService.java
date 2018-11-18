package com.baczewski.mvc.WebApplication.service;

import com.baczewski.mvc.WebApplication.domain.Customer;

import java.util.List;

public interface CustomerService {
    //CRUD

    //C
    void save(Customer customer);

    //R
    Customer getOne(Integer id);
    List<Customer> getAll();

    //U
    Customer update(Customer customer);

    //D
    void delete(Integer id);

    Customer add(Customer customer);

}
