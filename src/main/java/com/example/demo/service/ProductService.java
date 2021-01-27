package com.example.demo.service;

import com.example.demo.model.Product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List <Product> getAll();

    Product get(long id);

    Product add(Product product);

    Product update(Product product);

    void delete (long id);

//    Page<Product> search(ProductSearchParams searchParams);
}
