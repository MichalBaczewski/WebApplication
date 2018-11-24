package com.baczewski.mvc.WebApplication.controllers;

import com.baczewski.mvc.WebApplication.domain.Customer;
import com.baczewski.mvc.WebApplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(path="customers/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public Customer showUser(@PathVariable Integer id) {
        return customerService.getOne(id);
    }

    @RequestMapping("/customers")
    public List<Customer> getCustomers(){
        return customerService.getAll();
    }

    @RequestMapping("customers/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer deleteCustomer(@PathVariable Integer id){
        customerService.delete(id);
        return customerService.getOne(id);
    }

/*    @RequestMapping("/update/{id}")
    public String updateCustomer(@PathVariable Integer id,
    Model model){
        Customer customer = customerService.getOne(id);
        model.addAttribute(customer);
        model.addAttribute("title", "Update");
        model.addAttribute("button", "Update customer");
        return "customerEdit";
    }

    @RequestMapping("/update")
    public String saveCustomer(Customer customer) {
        Customer update;
        if(customer.getId() != null) {
            update = customerService.update(customer);
        } else {
            update = customerService.add(customer);
        }
        return "redirect:/customer/" + update.getId();
    }*/

    @PostMapping(path = "customers/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveOrUpdateCustomer(@RequestBody Customer customer){
        customerService.add(customer);
    }
}
