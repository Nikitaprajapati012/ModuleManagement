package com.example.mylibrary.Model;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

/*** Created by nikita on 17/8/17.
 */

public class CartItems extends SugarRecord {
    @SerializedName("id")
    private Long id;
    @SerializedName("productName")
    private String productName;
    @SerializedName("description")
    private String description;
    @SerializedName("salePrice")
    private double salePrice;
    @SerializedName("quantity")
    private int quantity;

    public CartItems(Product product, int quantity) {
        this.quantity = quantity;
    }

    public CartItems() {
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSumPrice() {
        return getSalePrice() * quantity;
    }
    @Override
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }
}
