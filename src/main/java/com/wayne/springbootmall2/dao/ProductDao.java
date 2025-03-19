package com.wayne.springbootmall2.dao;

import com.wayne.springbootmall2.model.Product;

public interface ProductDao {
    Product getProductById(Integer productId);
}
