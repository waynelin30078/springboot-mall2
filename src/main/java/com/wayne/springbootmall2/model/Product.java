package com.wayne.springbootmall2.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wayne.springbootmall2.constant.ProductCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@Table(name="product")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @NotNull
    @Column(name = "product_name")
    private String productName;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private ProductCategory category;

    @NotNull
    @Column(name = "image_url")
    private String imageUrl;

    @NotNull
    @Column(name = "price")
    private Integer price;

    @NotNull
    @Column(name = "stock")
    private Integer stock;

    @Column(name = "description")
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_date",updatable = false)
    @CreationTimestamp // 自動設置創建時間
    private LocalDateTime createdDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name ="last_modified_date")
    @UpdateTimestamp
    private LocalDateTime lastModifiedDate;

}
