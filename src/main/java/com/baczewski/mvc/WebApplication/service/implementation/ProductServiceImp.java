package com.baczewski.mvc.WebApplication.service.implementation;

import com.baczewski.mvc.WebApplication.domain.Product;
import com.baczewski.mvc.WebApplication.repository.ProductRepository;
import com.baczewski.mvc.WebApplication.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product getOneProduct(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> getAllProducts() {
        Iterable<Product> allProducts = productRepository.findAll();
        List<Product> products = new LinkedList<>();
        for (Product p : allProducts) {
            products.add(p);
        }
        return products;
    }

    @Override
    public Product saveOrUpdateProduct(Product product) {
        productRepository.save(product);
        return productRepository.findById(product.getId()).get();
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product addProduct(Product product) {
        productRepository.save(product);
        return productRepository.findById(product.getId()).get();
    }
}
