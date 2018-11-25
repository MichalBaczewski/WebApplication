package com.baczewski.mvc.WebApplication.controllers;

import com.baczewski.mvc.WebApplication.domain.Customer;
import com.baczewski.mvc.WebApplication.domain.Product;
import com.baczewski.mvc.WebApplication.service.implementation.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        Product product = productService.getOneProduct(id);
        model.addAttribute("product", product);
        return "product";
    }

    @RequestMapping("/list")
    public String allProducts(Model model){
        List<Product> allProducts = productService.getAllProducts();
        model.addAttribute("products", allProducts);
        return "productsList";
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
        return "redirect:/product/list";
    }

    @RequestMapping("/update/{id}")
    public String updateProduct(@PathVariable Integer id,
                                 Model model){
        Product product = productService.getOneProduct(id);
        model.addAttribute(product);
        model.addAttribute("title", "Update");
        model.addAttribute("button", "Update product");
        return "productEdit";

    }

    @RequestMapping("/update")
    public String saveProduct(Product product) {
        Product update;
        if(product.getId() != null) {
            update = productService.saveOrUpdateProduct(product);
        } else {
            update = productService.saveOrUpdateProduct(product);
        }
        return "redirect:/product/" + update.getId();
    }


    @GetMapping("/new")
    public String newCustomer(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("title", "Creation");
        model.addAttribute("button", "Create product");
        return "productEdit";
    }
}
