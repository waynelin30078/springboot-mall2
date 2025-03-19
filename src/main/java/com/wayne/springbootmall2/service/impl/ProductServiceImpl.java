package com.wayne.springbootmall2.service.impl;

import com.wayne.springbootmall2.model.Product;
import com.wayne.springbootmall2.repository.ProductRepository;
import com.wayne.springbootmall2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product getProductById(Integer productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public Integer createProduct(Product product) {
        return (productRepository.save(product).getProductId());
    }
}
