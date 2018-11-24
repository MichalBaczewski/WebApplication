package com.baczewski.mvc.WebApplication.controllers;

import com.baczewski.mvc.WebApplication.domain.Product;
import com.baczewski.mvc.WebApplication.service.implementation.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    ProductServiceImp productService;

    @Autowired
    public ProductController(ProductServiceImp productServiceImp) {
        this.productService = productServiceImp;
    }

    @RequestMapping("/{id}")
    public String showProduct(@PathVariable Integer id, Model model) {
        Product product = productService.getOne(id);
        model.addAttribute("product", product);
        return "product";
    }

    @RequestMapping("/list")
    public String allProducts(Model model){
        List<Product> allProducts = productService.getAll();
        model.addAttribute("products", allProducts);
        return "productsList";
    }

}
