package com.wayne.springbootmall2.controller;

import com.wayne.springbootmall2.dto.ProductRequest;
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

    /**
     * 根據商品ID取得商品的詳細資料。
     * 如果商品存在，則回傳商品資訊；否則回傳 404 NOT FOUND。
     *
     * @param productId 商品的唯一識別碼，為路徑變數。
     * @return ResponseEntity 包含商品資訊的回應實體，若商品存在則回傳 HTTP 200 OK 與商品資訊，
     *         若商品不存在則回傳 HTTP 404 NOT FOUND。
     */
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
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        Integer productId = productService.createProduct(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.getProductById(productId));
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId, @RequestBody @Valid ProductRequest productRequest) {
        //檢查product是否存在
        Product product = productService.getProductById(productId);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        //修改商品的數據
        productService.updateProduct(product,productRequest);
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductById(productId));
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Integer productId) {
        productService.deleteProductById(productId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
