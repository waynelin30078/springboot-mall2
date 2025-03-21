package com.wayne.springbootmall2.service.impl;

import com.wayne.springbootmall2.dto.ProductRequest;
import com.wayne.springbootmall2.model.Product;
import com.wayne.springbootmall2.repository.ProductRepository;
import com.wayne.springbootmall2.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product getProductById(Integer productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        Product product = new Product();
        BeanUtils.copyProperties(productRequest, product);
        return (productRepository.save(product).getProductId());
    }

    @Override
    public void updateProduct(Product product, ProductRequest productRequest) {
        Optional.ofNullable(productRequest.getProductName()).ifPresent(product::setProductName);
        Optional.ofNullable(productRequest.getCategory()).ifPresent(product::setCategory);
        Optional.ofNullable(productRequest.getImageUrl()).ifPresent(product::setImageUrl);
        Optional.ofNullable(productRequest.getPrice()).ifPresent(product::setPrice);
        Optional.ofNullable(productRequest.getStock()).ifPresent(product::setStock);
        Optional.ofNullable(productRequest.getDescription()).ifPresent(product::setDescription);

        productRepository.save(product);
    }

    @Override
    public void deleteProductById(Integer productId) {
        productRepository.deleteById(productId);
    }


}
