package com.example.demo.service;


import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.Product;

import com.example.demo.repository.ProductRepository;

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
        String msg = String.format("Product with id: %d Not Found", id);
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException(msg));
    }

    @Override
    public Product add(Product product){
        product.setId(null);
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
//    @Override
//    public Page<Product> search(ProductSearchParams SearchParams){
//        Sort sort = Sort.by(Sort.Direction.DESC, "id");
//        return productRepository.findAll((root, query, cb) -> {
//            Predicate predicate = cb.conjunction();
//            if (isNotEmpty(SearchParams.getBrand()rand())) {
//                predicate = cb.and(predicate, cb.like(root.get(brand), searchParams.getBrand() + "%"));
//            }
//            return predicate;
//
//        },SearchParams.toPageRequest(sort));
//    }
}
