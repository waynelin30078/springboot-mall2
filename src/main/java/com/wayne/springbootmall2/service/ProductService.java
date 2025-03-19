package com.wayne.springbootmall2.service;

import com.wayne.springbootmall2.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);
    Integer createProduct(Product product);
}
