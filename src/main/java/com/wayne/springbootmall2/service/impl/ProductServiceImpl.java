package com.wayne.springbootmall2.service.impl;

import com.wayne.springbootmall2.dao.ProductDao;
import com.wayne.springbootmall2.model.Product;
import com.wayne.springbootmall2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;
    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
