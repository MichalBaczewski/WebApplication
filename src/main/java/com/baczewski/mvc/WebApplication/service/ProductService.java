package com.baczewski.mvc.WebApplication.service;


import com.baczewski.mvc.WebApplication.domain.Product;
import java.util.List;

public interface ProductService {
    //CRUD

    //C
    void save(Product product);

    //R
    Product getOne(Integer id);
    List<Product> getAll();

    //U
    Product update(Product product);

    //D
    void delete(Integer id);

    Product add(Product product);

}
