package com.wayne.springbootmall2.service;

import com.wayne.springbootmall2.dto.ProductRequest;
import com.wayne.springbootmall2.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Product product, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
