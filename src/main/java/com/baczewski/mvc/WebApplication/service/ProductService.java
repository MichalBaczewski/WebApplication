package com.baczewski.mvc.WebApplication.service;

import com.baczewski.mvc.WebApplication.domain.Product;
import java.util.List;

public interface ProductService {

    //CRUD

    //C
    Product addProduct(Product product);

    //R
    Product getOneProduct(Integer id);
    List<Product> getAllProducts();

    //C&U
    Product saveOrUpdateProduct(Product product);

    //D
    void deleteProduct(Integer id);



}
