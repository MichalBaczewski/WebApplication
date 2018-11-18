package com.baczewski.mvc.WebApplication.service.implementation;

import com.baczewski.mvc.WebApplication.domain.Customer;
import com.baczewski.mvc.WebApplication.repository.CustomerRepository;
import com.baczewski.mvc.WebApplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImp implements CustomerService {

    private Map<Integer, Customer> customers;

    @Autowired
    CustomerRepository repository;

    public CustomerServiceImp() {
        customers = new HashMap<>();
        for (int i = 1; i < 51; i++) {
            Customer customer = new Customer();
            customer.setId(i);
            customer.setFirstName("Pawel");
            customer.setLastName("Baranczuk");
            customer.setAddressLine("Wiejska 4/" + i);
            customer.setEmail("baranczuk@buziaczek.pl");
            customer.setPhoneNumber("700-111-" + i);
            customer.setZipCode("15-3" + i);
            customer.setCity("Bialystok");
            customers.put(i, customer);
        }
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public Customer getOne(Integer id) {
        Customer customer = null;
        if (repository.findById(id).isPresent()) {
            customer = repository.findById(id).get();
        }
        return customer;
    }

    @Override
    public List<Customer> getAll() {

        Iterable<Customer> all = repository.findAll();
        LinkedList<Customer> list = new LinkedList<>();
        for (Customer c : all) {
            list.add(c);
        }
        return list;
    }

    @Override
    public Customer update(Customer customer) {
        customers.put(customer.getId(),customer);
        return customers.get(customer.getId());
    }

    @Override
    public void delete(Integer id) {
        customers.remove(id);
    }

    @Override
    public Customer add(Customer customer) {
        customer.setId(generatorIdKey());
        customers.put(customer.getId(),customer);
        return customers.get(customer.getId());
    }

    private Integer generatorIdKey() {
        return Collections.max(customers.keySet()) + 1;
    }
}

/**
 *  private Map<Integer, Customer> customers;

    @Autowired
    CustomerRepository repository;

    public CustomerServiceImp() {
        customers = new HashMap<>();
        for (int i = 1; i < 51; i++) {
            Customer customer = new Customer();
            customer.setId(i);
            customer.setFirstName("Pawel");
            customer.setLastName("Baranczuk");
            customer.setAddressLine("Wiejska 4/" + i);
            customer.setEmail("baranczuk@buziaczek.pl");
            customer.setPhoneNumber("700-111-" + i);
            customer.setZipCode("15-3" + i);
            customer.setCity("Bialystok");
            customers.put(i, customer);
        }
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public Customer getOne(Integer id) {
        return customers.get(id);
    }

    @Override
    public List<Customer> getAll() {

        Iterable<Customer> all = repository.findAll();
        LinkedList<Customer> list = new LinkedList<>();
        for (Customer c : all) {
            list.add(c);
        }
        return list;
    }

    @Override
    public Customer update(Customer customer) {
        customers.put(customer.getId(),customer);
        return customers.get(customer.getId());
    }

    @Override
    public void delete(Integer id) {
        customers.remove(id);
    }

    @Override
    public Customer add(Customer customer) {
        customer.setId(generatorIdKey());
        customers.put(customer.getId(),customer);
        return customers.get(customer.getId());
    }

    private Integer generatorIdKey() {
        return Collections.max(customers.keySet()) + 1;
    }
}
* */
