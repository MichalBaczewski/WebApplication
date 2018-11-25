package com.baczewski.mvc.WebApplication.service.implementation;

import com.baczewski.mvc.WebApplication.domain.Customer;
import com.baczewski.mvc.WebApplication.repository.CustomerRepository;
import com.baczewski.mvc.WebApplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer getOneCustomer(Integer id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public List<Customer> getAllCustomers() {
        Iterable<Customer> all = customerRepository.findAll();
        LinkedList<Customer> list = new LinkedList<>();
        for (Customer c : all) {
            list.add(c);
        }
        return list;
    }

    //w wolnej chwili przepiąć się z add na save or update
    @Override
    public Customer saveOrUpdateCustomer(Customer customer) {
        customerRepository.save(customer);
        return customerRepository.findById(customer.getId()).get();
    }

/*    @Override
    public Customer saveOrUpdateCustomer(Customer customer) {
        if(customer != null) {
            if (customer.getId() == null) {
                customer.setId(customerIdKeyGenerator());
                customerRepository.save(customer);
            } else {
                throw new RuntimeException("Can't be null");
            }
        }
        return customerRepository.findById(customer.getId()).get();
    }*/

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer addCustomer(Customer customer) {
        customerRepository.save(customer);
        return customerRepository.findById(customer.getId()).get();
    }

}
