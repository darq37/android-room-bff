package com.darq37.roombackend.controller;

import com.darq37.roombackend.domain.Product;
import com.darq37.roombackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getProducts() {
        System.out.println("Products retrieved.");
        return productService.getProducts();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Product> getProducts(@PathVariable Long id) {
        System.out.println(String.format("Product with id: '%s' retrieved.", id));
        return productService.getProduct(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<Product> saveProducts(@RequestBody List<Product> products) {
        System.out.println("Products saved.");
        return productService.saveAll(products);
    }


}
