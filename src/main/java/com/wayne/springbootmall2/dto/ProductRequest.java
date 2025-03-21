package com.wayne.springbootmall2.dto;

import com.wayne.springbootmall2.constant.ProductCategory;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductRequest {
    /**
     * 表示產品的名稱。
     * 此欄位為必填，不能為空。
     */
    @NotNull
    private String productName;
    /**
     * 表示產品的類別。
     * 必須為非空值。
     * 可用的類別包括 FOOD、CAR、E_BOOK。
     */
    @NotNull
    private ProductCategory category;
    /**
     * 表示產品的圖片網址，應提供對應圖片的有效 URL。
     * 此屬性不允許為空，必須設定非空字串。
     */
    @NotNull
    private String imageUrl;
    /**
     * 商品的價格。
     * 該屬性不能為空，應用於描述商品的價格，以整數表示。
     */
    @NotNull
    private Integer price;
    /**
     * 表示產品的庫存數量。
     * 必須為非空值(Integer)，用於描述產品目前可用的存貨數。
     */
    @NotNull
    private Integer stock;
    /**
     * 描述商品的詳細資訊，例如功能、特色或其他補充內容。
     */
    private String description;


}
