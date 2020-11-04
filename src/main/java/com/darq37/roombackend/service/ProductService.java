package com.darq37.roombackend.service;

import com.darq37.roombackend.domain.Product;
import com.darq37.roombackend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProduct(Long id){
        return productRepository.findById(id);
    }
}
