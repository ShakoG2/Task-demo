package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("product")
//@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @Transactional()
    public List<Product> getProduct(){
        return productService.getAll();
    }
    @PostMapping
    @Transactional
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.add(product));
    }

    @PutMapping("{id}")
    public Product updateCustomer(@PathVariable long id,
                                   @RequestBody Product unsaProduct) {
        Product product = productService.get(id);
        return productService.update(unsaProduct);
    }
    @GetMapping("{id}")
    public Product getCustomer(@PathVariable long id) {
        return productService.get(id);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
