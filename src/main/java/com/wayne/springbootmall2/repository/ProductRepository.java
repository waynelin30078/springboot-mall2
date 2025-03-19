package com.wayne.springbootmall2.repository;

import com.wayne.springbootmall2.model.Product;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product, Integer> {
}
