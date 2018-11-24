package com.baczewski.mvc.WebApplication.service.implementation;

import com.baczewski.mvc.WebApplication.domain.Product;
import com.baczewski.mvc.WebApplication.repository.ProductRepository;
import com.baczewski.mvc.WebApplication.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImp implements ProductService {

    Map<Integer, Product> products;

    @Autowired
    ProductRepository productRepository;

    @Override
    public void save(Product product) {

    }

    @Override
    public Product getOne(Integer id) {
        Product product = null;
        if(productRepository.findById(id).isPresent()) {
            product =  productRepository.findById(id).get();
        }
        return product;
    }

    @Override
    public List<Product> getAll() {
        Iterable<Product> allCustomers = productRepository.findAll();
        List<Product> products = new LinkedList<>();
        for (Product p : allCustomers) {
            products.add(p);
        }
        return products;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        products.remove(id);
    }

    @Override
    public Product add(Product product) {
        return null;
    }
}
