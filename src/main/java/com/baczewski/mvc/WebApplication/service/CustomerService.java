package com.baczewski.mvc.WebApplication.service;

import com.baczewski.mvc.WebApplication.domain.Customer;
import java.util.List;

public interface CustomerService {

    //CRUD

    //C
    Customer addCustomer(Customer customer);

    //R
    Customer getOneCustomer(Integer id);
    List<Customer> getAllCustomers();

    //C&U
    Customer saveOrUpdateCustomer(Customer customer);

    //D
    void deleteCustomer(Integer id);



}
