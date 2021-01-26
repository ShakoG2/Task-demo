package com.example.demo.service;


import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> getAll(){
        return productRepository.findAll();
    }

    @Override
    public Product get(long id){
        String msg = String.format("Customer with id: %d Not Found", id);
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException(msg));
    }

    @Override
    public Product add(Product product){
        return productRepository.save(product);
    }

    @Override
    public  Product update(Product product){
        return  productRepository.save(product);
    }
    @Override
    public void  delete(long id){
        get(id);
        productRepository.deleteById(id);
    }
}
