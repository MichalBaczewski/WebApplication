package com.baczewski.mvc.WebApplication.controllers;

import com.baczewski.mvc.WebApplication.domain.Customer;
import com.baczewski.mvc.WebApplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService service;

    @Autowired
    public void setService(CustomerService service) {
        this.service = service;
    }

    @RequestMapping("/{id}")
    public String showUser(
            @PathVariable Integer id,
            Model model) {
        Customer customer = service.getOne(id);
        model.addAttribute("customer", customer);
        return "customer";
    }

    @RequestMapping("/list")
    public String allCustomers(Model model){
        List<Customer> allCustomers = service.getAll();
        model.addAttribute("customers", allCustomers);
        return "customersList";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id){
        service.delete(id);
        return "redirect:/customer/list";
    }

    @RequestMapping("/update/{id}")
    public String updateCustomer(@PathVariable Integer id,
    Model model){
        Customer customer = service.getOne(id);
        model.addAttribute(customer);
        model.addAttribute("title", "Update");
        model.addAttribute("button", "Update customer");
        return "customerEdit";
    }

    @RequestMapping("/update")
    public String saveCustomer(Customer customer) {
        Customer update;
        if(customer.getId() != null) {
            update = service.update(customer);
        } else {
            update = service.add(customer);
        }
        return "redirect:/customer/" + update.getId();
    }

    @GetMapping("/new")
    public String newCustomer(Model model){
        model.addAttribute("customer", new Customer());
        model.addAttribute("title", "Creation");
        model.addAttribute("button", "Create customer");
        return "customerEdit";
    }
}
