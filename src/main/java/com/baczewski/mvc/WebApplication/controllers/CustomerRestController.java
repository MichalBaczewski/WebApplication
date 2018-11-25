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
        return customerService.getOneCustomer(id);
    }

    @RequestMapping("/customers")
    public List<Customer> getCustomers(){
        return customerService.getAllCustomers();
    }

    @RequestMapping("customers/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);
        return customerService.getOneCustomer(id);
    }

/*    @RequestMapping("/saveOrUpdateCustomer/{id}")
    public String updateCustomer(@PathVariable Integer id,
    Model model){
        Customer customer = customerService.getOneCustomer(id);
        model.addAttribute(customer);
        model.addAttribute("title", "Update");
        model.addAttribute("button", "Update customer");
        return "customerEdit";
    }

    @RequestMapping("/saveOrUpdateCustomer")
    public String saveCustomer(Customer customer) {
        Customer saveOrUpdateCustomer;
        if(customer.getId() != null) {
            saveOrUpdateCustomer = customerService.saveOrUpdateCustomer(customer);
        } else {
            saveOrUpdateCustomer = customerService.addCustomer(customer);
        }
        return "redirect:/customer/" + saveOrUpdateCustomer.getId();
    }*/

    @PostMapping(path = "customers/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveOrUpdateCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
    }
}
