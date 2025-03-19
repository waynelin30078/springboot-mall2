package com.wayne.springbootmall2.controller;

import com.wayne.springbootmall2.model.Product;
import com.wayne.springbootmall2.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
   private ProductService productService;

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId) {
        Product product = productService.getProductById(productId);
        if (product != null) {
            return  ResponseEntity.status(HttpStatus.OK).body(product);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid Product product) {
        Integer productId = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.getProductById(productId));
    }


}
