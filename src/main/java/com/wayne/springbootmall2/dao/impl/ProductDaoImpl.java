package com.wayne.springbootmall2.dao.impl;

import com.wayne.springbootmall2.dao.ProductDao;
import com.wayne.springbootmall2.model.Product;
import com.wayne.springbootmall2.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Product getProductById(Integer productId) {
        String sql = "select product_id,product_name, category," +
                " image_url, price, stock," +
                " description, created_date, last_modified_date " +
                "from product where product_id = :productId";
        Map<String, Object> params = new HashMap<>();
        params.put("productId", productId);

        List<Product> productList = namedParameterJdbcTemplate.query(sql, params, new ProductRowMapper());
        if (!productList.isEmpty()) {
            return productList.get(0);
        }else {
            return null;
        }
    }
}
