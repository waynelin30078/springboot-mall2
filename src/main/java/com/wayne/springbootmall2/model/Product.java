package com.wayne.springbootmall2.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wayne.springbootmall2.constant.ProductCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * Product 類別代表商品的實體。
 * 該類別使用 JPA 註解來對應資料庫中的 `product` 表，並包含商品的相關屬性與元資料。
 * 此類別也支援自動時間戳的更新與格式化，以及動態更新機制。
 *
 * 屬性：
 * - productId: 商品的唯一識別碼。
 * - productName: 商品名稱。
 * - category: 商品類別，使用枚舉類型 {@link ProductCategory}。
 * - imageUrl: 商品圖片的 URL。
 * - price: 商品價格。
 * - stock: 商品庫存數量。
 * - description: 商品描述。
 * - createdDate: 商品創建的時間，自動生成且不可更新。
 * - lastModifiedDate: 最後修改時間，自動生成。
 *
 * 此類別通常用於表示資料庫實體，並可與 Repository 和 Service 層互動來進行 CRUD 操作。
 */
@Setter
@Getter
@Table(name="product")
@DynamicUpdate
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name")
    private String productName;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private ProductCategory category;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "price")
    private Integer price;

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
